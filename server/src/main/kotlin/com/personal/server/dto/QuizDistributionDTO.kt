package com.personal.server.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class QuizDistributionDTO(
    val distributionId: UUID,
    @JsonProperty("quiz")
    val quizDTO: QuizDTO,

    )