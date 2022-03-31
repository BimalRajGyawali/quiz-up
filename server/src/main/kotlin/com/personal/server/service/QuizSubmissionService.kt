package com.personal.server.service

import com.personal.server.dto.QuizSubmissionDTO
import com.personal.server.dto.SubmissionSummaryDTO

interface QuizSubmissionService {

    fun submitQuiz(quizSubmissionDTO: QuizSubmissionDTO) : SubmissionSummaryDTO
}