package com.personal.server.service

import com.personal.server.dto.QuizData
import java.util.UUID

interface QuizService {
    fun createQuiz(quizData: QuizData): UUID

    fun getAllQuizzes(): List<QuizData>
}