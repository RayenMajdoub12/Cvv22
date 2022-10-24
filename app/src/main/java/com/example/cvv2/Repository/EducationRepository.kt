package com.example.cvv2.Repository

import androidx.room.*
import com.example.cvv2.Entity.Education

@Dao
interface EducationRepository {
    @Insert
    fun insert(education: Education)

    @Update
    fun update(education: Education)

    @Delete
    fun delete(education: Education)

    @Query("SELECT * FROM Education")
    fun getAllChamps(): List<Education>
}