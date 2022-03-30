package com.personal.server.service.impl

import com.personal.server.dto.QuizData
import com.personal.server.dto.QuizDistributionData
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


    private fun createQuiz(quizData: QuizData, draft: Boolean): UUID {
        var quiz = Quiz(
            title = quizData.title,
            durationInMinute = quizData.durationInMinute,
            draft = draft,
            publishAt = if (draft) null else LocalDateTime.now(),
            maxAttempt = quizData.maxAttempt,
        )

        quiz = quizRepo.save(quiz)

        val questions = quizData.questions.map {
            buildQuestion(it, quiz)
        }

        questionRepo.saveAll(questions)

        quiz.totalQuestions = questions.size

        quizRepo.save(quiz)

        return quiz.id
    }

    @Transactional
    override fun publishQuiz(quizData: QuizData): UUID {
        return createQuiz(quizData, false)
    }

    override fun draftQuiz(quizData: QuizData): UUID {
        return createQuiz(quizData, true)
    }

    override fun getAllPublishedQuiz(): List<QuizData> {
        return quizRepo.findAllByDraft(false).map { quiz ->
            QuizData(
                id = quiz.id,
                title = quiz.title,
                durationInMinute = quiz.durationInMinute,
                maxAttempt = quiz.maxAttempt,
                questions = listOf(),
                publishAt = quiz.publishAt
            )
        }
    }

    override fun getPublishedQuizById(id: UUID): QuizDistributionData {
        val quiz = quizRepo.findByIdOrNull(id) ?: throw RuntimeException("Not Found")

        val quizDistribution = quizDistributionRepo.findFirstByQuizIdOrderByAttemptNoDesc(id)
            ?: QuizDistribution(quiz = quiz)

        if (quizDistribution.attemptNo >= quiz.maxAttempt) {
            throw RuntimeException("Maximum attempts finished")
        }

        quizDistribution.attemptNo += 1

        quizDistributionRepo.save(quizDistribution)

        return QuizDistributionData(
            quizDistribution.id,
            QuizData(
                id = quiz.id,
                title = quiz.title,
                durationInMinute = quiz.durationInMinute,
                maxAttempt = quiz.maxAttempt,
                questions = questionRepo.getAllByQuizId(quiz.id).map {
                    buildQuestionData(it)
                },
                publishAt = quiz.publishAt
            )
        )


    }

}