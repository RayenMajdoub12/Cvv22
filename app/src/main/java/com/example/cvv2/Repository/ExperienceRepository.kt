package com.example.cvv2.Repository

import androidx.room.*
import com.example.cvv2.Entity.Education
import com.example.cvv2.Entity.Experience

@Dao
interface ExperienceRepository {
    @Insert
    fun insert(experience: Experience)

    @Update
    fun update(experience: Experience)

    @Delete
    fun delete(experience: Experience)

    @Query("SELECT * FROM Experience")
    fun getAllExperience(): List<Experience>
}