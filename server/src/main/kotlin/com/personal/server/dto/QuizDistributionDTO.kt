package com.personal.server.dto

import java.util.UUID

data class QuizDistributionDTO(
    val distributionId: UUID,
    val quizDTO: QuizDTO,

    )