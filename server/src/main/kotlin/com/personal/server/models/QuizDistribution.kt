package com.personal.server.models

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class QuizDistribution(
    @Id
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    val quiz: Quiz,

    var attemptNo: Int = 0,

    val startTime: LocalDateTime = LocalDateTime.now(),

    val submittedTime: LocalDateTime? = null,

    val grade: Double = 0.0

)