package com.personal.server.dto

import java.util.UUID

class QuizData(
    val id: UUID?,
    val title: String,
    val fullMarks: Double,
    val passMarks: Double,
    val questions: List<QuestionData>,
)