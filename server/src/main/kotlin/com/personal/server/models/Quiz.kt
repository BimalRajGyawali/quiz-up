package com.personal.server.models

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Quiz(
    @Id
    val id: UUID = UUID.randomUUID(),

    val title: String,

    val fullMarks: Double,

    val passMarks: Double
){
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    lateinit var questions: List<Question>
}