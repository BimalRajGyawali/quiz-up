package com.personal.server.service

import com.personal.server.dto.QuizSubmissionData

interface QuizSubmissionService {

    fun submitQuiz(quizSubmissionData: QuizSubmissionData)
}