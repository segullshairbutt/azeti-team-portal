package com.teamportal.repository

import com.teamportal.model.Activity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<Activity, Long> {
    fun findByUserId(userId: Long): List<Activity>

    fun findFirstByUserIdOrderByTimestampDesc(userId: Long): Activity?
}
