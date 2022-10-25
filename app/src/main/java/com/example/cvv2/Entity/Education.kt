package com.example.cvv2.Entity

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Education(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val UniPic: String,
    val UniName:String,
    val UniAdress:String,
    val Start_date:String,
    val End_date:String
)
