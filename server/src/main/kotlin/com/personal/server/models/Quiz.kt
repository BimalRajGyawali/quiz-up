package com.personal.server.models

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Quiz(
    @Id
    val id: UUID = UUID.randomUUID(),

    val title: String,

    val durationInMinute: Int,

    val draft: Boolean,

    val maxAttempt: Int,

    val publishAt: LocalDateTime? = null,

    var totalQuestions: Int = 0,

    )