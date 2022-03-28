package com.personal.server.controller

import com.personal.server.dto.QuizData
import com.personal.server.service.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/quizzes")
class QuizController(
    private val quizService: QuizService
) {

    @PostMapping("/publish")
    fun publishQuiz(@RequestBody quizData: QuizData) : ResponseEntity<*>{
        return ResponseEntity.ok(
            mapOf("id" to quizService.publishQuiz(quizData))
        )
    }

    @PostMapping("/draft")
    fun draftQuiz(@RequestBody quizData: QuizData) : ResponseEntity<*>{
        return ResponseEntity.ok(
            mapOf("id" to quizService.draftQuiz(quizData))
        )
    }

    @GetMapping("/")
    fun getAllPublishedQuizzes() : ResponseEntity<*>{
        return ResponseEntity.ok(
            quizService.getAllPublishedQuiz()
        )
    }

    @GetMapping("/{id}")
    fun getPublishedQuizById(@PathVariable id: UUID) : ResponseEntity<*>{
        return ResponseEntity.ok(
            quizService.getPublishedQuizById(id)
        )
    }
}