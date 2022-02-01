package com.personal.server.repo

import com.personal.server.models.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepo : JpaRepository<Question, Int>