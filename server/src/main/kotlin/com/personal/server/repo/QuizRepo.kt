package com.personal.server.repo

import com.personal.server.models.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface QuizRepo : JpaRepository<Quiz, UUID>