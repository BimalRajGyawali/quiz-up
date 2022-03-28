package com.personal.server.service

import com.personal.server.dto.QuizData
import java.util.UUID

interface QuizService {
    fun publishQuiz(quizData: QuizData): UUID
    fun draftQuiz(quizData: QuizData): UUID
    fun getAllPublishedQuiz(): List<QuizData>
    fun getPublishedQuizById(id: UUID): QuizData
}