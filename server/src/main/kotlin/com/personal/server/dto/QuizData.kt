package com.personal.server.dto

import java.time.LocalDateTime
import java.util.UUID

data class QuizData(
    val id: UUID?,
    val title: String,
    val durationInMinute: Int,
    val maxAttempt: Int,
    val questions: List<QuestionData>,
    val publishAt: LocalDateTime? = null,
)