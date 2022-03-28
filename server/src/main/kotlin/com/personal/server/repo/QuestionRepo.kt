package com.personal.server.repo

import com.personal.server.models.Question
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface QuestionRepo : JpaRepository<Question, Int> {
    fun getAllByQuizId(id : UUID) : List<Question>
}