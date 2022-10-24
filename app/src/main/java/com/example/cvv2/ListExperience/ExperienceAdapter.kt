package com.example.cvv2.ListExperience

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cvv2.Entity.Experience
import com.example.cvv2.R
import com.example.cvv2.utils.AppDataBase

class ExperienceAdapter(val ExperienceList:MutableList<Experience>) : RecyclerView.Adapter<ExperienceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_card,parent,false)
        return ExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val name = ExperienceList[position].CompanyName
        val adress = ExperienceList[position].CompanyAdress
        val Startdate = ExperienceList[position].Start_date
        val Enddate = ExperienceList[position].End_date
        val image = ExperienceList[position].CompanyPic


        holder.CompanyPic.setImageResource(image)
        holder.CompanyName.text = name
        holder.CompanyAdress.text = adress
        holder.Start_date.text = Startdate
        holder.End_date.text = Enddate


     /*   holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.apply {
                putExtra(PICTURE, championsList[position].champPic)
                putExtra(NAME, name)
                putExtra(ROLE, role)
            }
            holder.itemView.context.startActivity(intent)
        }*/

        holder.btnDelete.setOnClickListener {
            //TODO 13 "Delete a champion from the database and refresh the recyclerView"
            AppDataBase.getDatabase(holder.itemView.context).ExperienceDao().delete(ExperienceList[position])
            ExperienceList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return ExperienceList.size
    }


}