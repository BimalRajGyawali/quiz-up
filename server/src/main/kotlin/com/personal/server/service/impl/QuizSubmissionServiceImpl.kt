package com.personal.server.service.impl

import com.personal.server.dto.QuizSubmissionDTO
import com.personal.server.dto.SubmissionSummaryDTO
import com.personal.server.models.QuizDistribution
import com.personal.server.models.UserAnswer
import com.personal.server.repo.QuestionRepo
import com.personal.server.repo.QuizDistributionRepo
import com.personal.server.repo.UserAnswerRepo
import com.personal.server.service.QuizSubmissionService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class QuizSubmissionServiceImpl(
    private val quizDistributionRepo: QuizDistributionRepo,
    private val userAnswerRepo: UserAnswerRepo,
    private val questionRepo: QuestionRepo
) : QuizSubmissionService {

    override fun submitQuiz(quizSubmissionDTO: QuizSubmissionDTO) : SubmissionSummaryDTO {
        val quizDistribution = quizDistributionRepo.findByIdOrNull(quizSubmissionDTO.quizDistributionId)
            ?: throw RuntimeException("You cannot submit this")

        if (quizDistribution.submittedTime != null) {
            throw RuntimeException("Already submitted")
        }

        val limit = quizDistribution.startTime
            .plusMinutes(quizDistribution.quiz.durationInMinute.toLong())

        if (LocalDateTime.now().isAfter(limit)) {
            throw RuntimeException("time limit exceeded")
        }

        quizDistribution.submittedTime = LocalDateTime.now()

        computeGradeAndSaveAnswers(quizSubmissionDTO, quizDistribution)

        return SubmissionSummaryDTO(
            quizDistribution.id,
            quizDistribution.attemptNo,
            quizDistribution.grade
        )

    }

    private fun computeGradeAndSaveAnswers(
        quizSubmissionDTO: QuizSubmissionDTO,
        quizDistribution: QuizDistribution
    ) {
        var grade = 0.0
        val userAnswers = mutableListOf<UserAnswer>()

        for (userAnswerDTO in quizSubmissionDTO.userAnswers) {
            val question = questionRepo.findByIdOrNull(userAnswerDTO.questionId) ?: continue
            if (question.correctOption == userAnswerDTO.optionChosen) {
                grade += question.weight
            }

            userAnswers.add(
                UserAnswer(
                    quizDistribution = quizDistribution,
                    question = question,
                    optionChosen = userAnswerDTO.optionChosen
                )
            )
        }

        userAnswerRepo.saveAll(userAnswers)
        quizDistribution.grade = grade
        quizDistributionRepo.save(quizDistribution)
    }
}