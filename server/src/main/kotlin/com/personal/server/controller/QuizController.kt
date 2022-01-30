package com.personal.server.controller

import com.personal.server.service.QuizData
import com.personal.server.service.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quizzes")
class QuizController(
    private val quizService: QuizService
) {

    @PostMapping("/")
    fun createQuiz(@RequestBody quizData: QuizData) : ResponseEntity<*>{
        return ResponseEntity.ok(
            mapOf("id" to quizService.createQuiz(quizData))
        )
    }
}