package com.example.cvv2.ListExperience

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.cvv2.R

class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    val CompanyPic: ImageView
    val CompanyName: TextView
    val CompanyAdress:TextView
    val Start_date:TextView
    val End_date:TextView
    val btnDelete: Button
            init{
                CompanyPic = itemView.findViewById<ImageView>(R.id.myImageView)
                CompanyName = itemView.findViewById<TextView>(R.id.CompanyNameTV)
                CompanyAdress = itemView.findViewById<TextView>(R.id.CompanyAdressTv)
                Start_date = itemView.findViewById<TextView>(R.id.STARTDATE)
                End_date = itemView.findViewById<TextView>(R.id.ENDDATE)
                btnDelete=itemView.findViewById<Button>(R.id.btnDelete)
            }
}