package com.personal.server.dto

import java.util.UUID

data class SubmissionDetailDTO(
    val quizDistributionId: UUID,
    val quizTitle: String,
    val fullMarks: Double,
    val grade: Double,
    val answers: List<UserAnswerOutputDTO>
)
