package com.personal.server.dto

import java.util.UUID

data class QuizSubmissionData(
    val quizDistributionId : UUID,
    val userAnswerData : List<UserAnswerData>
)