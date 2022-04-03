package com.personal.server.service

import com.personal.server.dto.QuizSubmissionDTO
import com.personal.server.dto.SubmissionDetailDTO
import com.personal.server.dto.SubmissionSummaryDTO
import java.util.UUID

interface QuizSubmissionService {

    fun submitQuiz(quizSubmissionDTO: QuizSubmissionDTO) : SubmissionSummaryDTO

    fun getSubmissionDetail(quizDistributionId: UUID) : SubmissionDetailDTO
}