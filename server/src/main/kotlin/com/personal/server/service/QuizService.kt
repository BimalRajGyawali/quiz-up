package com.personal.server.service

import com.personal.server.dto.QuizDTO
import com.personal.server.dto.QuizDistributionDTO
import java.util.UUID

interface QuizService {
    fun publishQuiz(quizDTO: QuizDTO): UUID
    fun draftQuiz(quizDTO: QuizDTO): UUID
    fun getAllPublishedQuiz(): List<QuizDTO>
    fun getPublishedQuizById(id: UUID): QuizDistributionDTO
}