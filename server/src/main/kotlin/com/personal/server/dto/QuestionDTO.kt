package com.personal.server.dto

import com.personal.server.models.Question
import com.personal.server.models.Quiz

data class QuestionData(
    val id: Int?,
    val title: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: String,
    val weight: Double
)

fun buildQuestion(questionData: QuestionData, quiz: Quiz): Question{
    return Question(
        title = questionData.title,
        option1 = questionData.option1,
        option2 = questionData.option2,
        option3 = questionData.option3,
        option4 = questionData.option4,
        correctOption = questionData.correctOption,
        weight = questionData.weight,
        quiz = quiz
    )
}

fun buildQuestionData(question: Question): QuestionData{
    return QuestionData(
        id = question.id,
        title = question.title,
        option1 = question.option1,
        option2 = question.option2,
        option3 = question.option3,
        option4 = question.option4,
        correctOption = question.correctOption,
        weight = question.weight
    )
}