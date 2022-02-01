package com.personal.server.service.impl

import com.personal.server.dto.QuestionData
import com.personal.server.dto.QuizData
import com.personal.server.models.Question
import com.personal.server.models.Quiz
import com.personal.server.repo.QuestionRepo
import com.personal.server.repo.QuizRepo
import com.personal.server.service.QuizService
import org.springframework.stereotype.Service
import java.util.UUID
import javax.transaction.Transactional

@Service
class QuizServiceImpl(
    private val quizRepo: QuizRepo,
    private val questionRepo: QuestionRepo
) : QuizService {

    @Transactional
    override fun createQuiz(quizData: QuizData): UUID {
        var quiz = Quiz(
            title = quizData.title,
            fullMarks = quizData.fullMarks,
            passMarks = quizData.passMarks
        )

        quiz = quizRepo.save(quiz)

        val questions = quizData.questions.map {
            Question(
                title = it.title,
                option1 = it.option1,
                option2 = it.option2,
                option3 = it.option3,
                option4 = it.option4,
                correctAnswer = it.rightOption,
                weight = it.weight,
                quiz = quiz
            )
        }

        questionRepo.saveAll(questions)

        return quiz.id
    }


    override fun getAllQuizzes(): List<QuizData> {
        return quizRepo.findAll()
            .map { quiz ->
                QuizData(quiz.id, quiz.title, quiz.fullMarks, quiz.passMarks,
                    quiz.questions.map {
                        QuestionData(
                            it.id, it.title, it.option1, it.option2, it.option3, it.option4,
                            it.correctAnswer, it.weight
                        )
                    })
            }
    }

}