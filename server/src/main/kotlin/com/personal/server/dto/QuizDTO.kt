package com.personal.server.dto

import java.util.UUID

data class QuizDTO(
    val id: UUID?,
    val title: String,
    val durationInMinute: Int,
    val maxAttempt: Int,
    val questions: List<QuestionData>,
    val publishAt: String?,
    val totalQuestions: Int,
    val fullMarks: Double
)