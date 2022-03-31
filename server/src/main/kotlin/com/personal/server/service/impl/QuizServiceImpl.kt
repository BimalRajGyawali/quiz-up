package com.personal.server.service.impl

import com.personal.server.dto.QuizDTO
import com.personal.server.dto.QuizDistributionDTO
import com.personal.server.dto.buildQuestion
import com.personal.server.dto.buildQuestionData
import com.personal.server.models.Quiz
import com.personal.server.models.QuizDistribution
import com.personal.server.repo.QuestionRepo
import com.personal.server.repo.QuizDistributionRepo
import com.personal.server.repo.QuizRepo
import com.personal.server.service.QuizService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID
import javax.transaction.Transactional

@Service
class QuizServiceImpl(
    private val quizRepo: QuizRepo,
    private val questionRepo: QuestionRepo,
    private val quizDistributionRepo: QuizDistributionRepo
) : QuizService {


    private fun createQuiz(quizDTO: QuizDTO, draft: Boolean): UUID {
        var quiz = Quiz(
            title = quizDTO.title,
            durationInMinute = quizDTO.durationInMinute,
            draft = draft,
            publishAt = if (draft) null else LocalDateTime.now(),
            maxAttempt = quizDTO.maxAttempt,
        )

        quiz = quizRepo.save(quiz)

        val questions = quizDTO.questions.map {
            buildQuestion(it, quiz)
        }

        questionRepo.saveAll(questions)

        quiz.totalQuestions = questions.size

        for(question in questions){
            quiz.fullMarks += question.weight
        }

        quizRepo.save(quiz)

        return quiz.id
    }

    @Transactional
    override fun publishQuiz(quizDTO: QuizDTO): UUID {
        return createQuiz(quizDTO, false)
    }

    override fun draftQuiz(quizDTO: QuizDTO): UUID {
        return createQuiz(quizDTO, true)
    }

    override fun getAllPublishedQuiz(): List<QuizDTO> {
        return quizRepo.findAllByDraft(false).map { quiz ->
            QuizDTO(
                id = quiz.id,
                title = quiz.title,
                durationInMinute = quiz.durationInMinute,
                maxAttempt = quiz.maxAttempt,
                questions = listOf(),
                publishAt = quiz.publishAt.toString(),
                totalQuestions = quiz.totalQuestions,
                fullMarks = quiz.fullMarks
            )
        }
    }

    override fun getPublishedQuizById(id: UUID): QuizDistributionDTO {
        val quiz = quizRepo.findByIdOrNull(id) ?: throw RuntimeException("Not Found")

        val quizDistribution = quizDistributionRepo.findFirstByQuizIdOrderByAttemptNoDesc(id)
            ?: QuizDistribution(quiz = quiz)

        if (quizDistribution.attemptNo >= quiz.maxAttempt) {
            throw RuntimeException("Maximum attempts finished")
        }

        quizDistribution.attemptNo += 1

        quizDistributionRepo.save(quizDistribution)

        return QuizDistributionDTO(
            quizDistribution.id,
            QuizDTO(
                id = quiz.id,
                title = quiz.title,
                durationInMinute = quiz.durationInMinute,
                maxAttempt = quiz.maxAttempt,
                questions = questionRepo.getAllByQuizId(quiz.id).map {
                    buildQuestionData(it)
                },
                publishAt = quiz.publishAt.toString(),
                totalQuestions = quiz.totalQuestions,
                fullMarks = quiz.fullMarks
            )
        )


    }

}