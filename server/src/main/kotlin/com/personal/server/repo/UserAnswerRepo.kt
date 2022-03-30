package com.personal.server.repo

import com.personal.server.models.UserAnswer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserAnswerRepo : JpaRepository<UserAnswer, UUID>