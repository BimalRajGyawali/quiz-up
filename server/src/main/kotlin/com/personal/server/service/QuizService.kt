package com.personal.server.service

import java.util.*

interface QuizService {
    fun createQuiz(quizData: QuizData): UUID
}

class QuizData(
    val title: String,
    val fullMarks: Double,
    val passMarks: Double,
    val questions: List<QuestionData>
)

class QuestionData(
    val title: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val rightOption: String,
    val weight: Double
)