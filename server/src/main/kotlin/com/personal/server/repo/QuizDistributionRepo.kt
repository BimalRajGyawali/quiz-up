package com.personal.server.repo

import com.personal.server.models.QuizDistribution
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface QuizDistributionRepo : JpaRepository<QuizDistribution, UUID>{

    fun findFirstByQuizIdOrderByAttemptNoDesc(quizId: UUID) : QuizDistribution?
}