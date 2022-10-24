package com.example.cvv2.Entity

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Experience(
    @DrawableRes
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val CompanyPic: Int,
    val CompanyName:String,
    val CompanyAdress:String,
    val Start_date:String,
    val End_date:String
)
