package com.personal.server.controller

import com.personal.server.dto.QuizSubmissionData
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/submissions")
class QuizSubmissionController {

    @PostMapping("/")
    fun submitQuiz(@RequestBody quizSubmissionData: QuizSubmissionData) {
        println(quizSubmissionData)
    }
}