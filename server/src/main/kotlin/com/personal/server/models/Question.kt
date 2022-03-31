package com.personal.server.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Question(
    @Id
    @GeneratedValue
    val id: Int = 0,

    val title: String,

    val option1: String,

    val option2: String,

    val option3: String,

    val option4: String,

    val correctOption: String,

    val weight: Double,

    @ManyToOne
    val quiz: Quiz
) {
    override fun toString(): String {
        return "Question(id=$id, title='$title 'correctOption='$correctOption', weight=$weight"
    }
}
