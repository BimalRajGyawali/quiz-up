package com.personal.server.dto

import java.util.UUID

data class QuizDistributionData(
    val distributionId: UUID,
    val quizData: QuizData,

)