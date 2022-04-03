package com.personal.server.dto

data class UserAnswerOutputDTO(
    val questionData: QuestionData,
    val optionChosen: String?
)