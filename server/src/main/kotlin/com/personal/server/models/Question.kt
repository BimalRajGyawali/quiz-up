package com.personal.server.models

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

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

    val correctAnswer: String,

    val weight: Double,

    @ManyToOne
    val quiz: Quiz
)

interface QuestionRepo : JpaRepository<Question, Int>