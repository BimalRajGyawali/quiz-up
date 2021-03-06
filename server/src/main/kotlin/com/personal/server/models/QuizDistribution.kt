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

    var attemptNo: Int,

    val startTime: LocalDateTime = LocalDateTime.now(),

    var submittedTime: LocalDateTime? = null,

    var grade: Double = 0.0

)