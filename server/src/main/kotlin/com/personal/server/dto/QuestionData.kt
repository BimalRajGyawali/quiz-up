package com.personal.server.dto


class QuestionData(
    val id: Int?,
    val title: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val rightOption: String,
    val weight: Double,
)