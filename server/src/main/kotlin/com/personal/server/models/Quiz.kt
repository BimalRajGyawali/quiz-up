package com.personal.server.models

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Quiz(
    @Id
    val id: UUID = UUID.randomUUID(),

    val title: String,

    val fullMarks: Double,

    val passMarks: Double
)

interface QuizRepo : JpaRepository<Quiz, UUID>