package com.personal.server.models

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
class UserAnswer(

    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val quizDistribution: QuizDistribution,

    @OneToOne
    val question: Question,

    val optionChosen: String

)