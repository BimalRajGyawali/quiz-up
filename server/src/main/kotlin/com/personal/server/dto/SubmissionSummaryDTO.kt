package com.personal.server.dto

import java.util.UUID

data class SubmissionSummaryDTO(
    val quizDistributionId : UUID,
    val attemptNo : Int,
    val grade : Double

)