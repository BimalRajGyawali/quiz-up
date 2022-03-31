package com.personal.server.dto

import java.util.UUID

data class QuizSubmissionDTO(
    val quizDistributionId : UUID,
    val userAnswers : List<UserAnswerDTO>
)