package com.personal.server.exceptions

import com.personal.server.dto.HttpResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler
    fun handleAppException(appException: AppException) : ResponseEntity<HttpResponse>{
        return ResponseEntity(HttpResponse(appException.msg), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}