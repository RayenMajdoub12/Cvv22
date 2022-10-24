package com.example.cvv2.utils

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cvv2.AddExperience
import com.example.cvv2.Entity.Education
import com.example.cvv2.Entity.Experience
import com.example.cvv2.Repository.EducationRepository
import com.example.cvv2.Repository.ExperienceRepository

@Database(entities = [Experience::class,Education::class], version = 1)
 abstract class AppDataBase :RoomDatabase(){
    abstract fun ExperienceDao(): ExperienceRepository
    abstract fun EducationDao(): EducationRepository

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "CV")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}