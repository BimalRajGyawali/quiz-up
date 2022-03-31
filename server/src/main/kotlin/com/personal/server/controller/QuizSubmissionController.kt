package com.personal.server.controller

import com.personal.server.dto.QuizSubmissionDTO
import com.personal.server.dto.SubmissionSummaryDTO
import com.personal.server.models.QuizDistribution
import com.personal.server.service.QuizSubmissionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/submissions")
class QuizSubmissionController(
    private val quizSubmissionService: QuizSubmissionService
) {

    @PostMapping("/")
    fun submitQuiz(@RequestBody quizSubmissionDTO: QuizSubmissionDTO) : ResponseEntity<SubmissionSummaryDTO> {
        return ResponseEntity.ok(quizSubmissionService.submitQuiz(quizSubmissionDTO))
    }
}