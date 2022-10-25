package com.example.cvv2.Entity

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Experience(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val CompanyPic: String,
    val CompanyName:String,
    val CompanyAdress:String,
    val Start_date:String,
    val End_date:String
)
