package com.example.cvv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Hobbies.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Hobbies : Fragment(R.layout.fragment__hobbies) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val Bundle= arguments
         val hobbies =Bundle!!.getString("Hobbies")
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+hobbies+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

        val checkboxmusic = view.findViewById<CheckBox>(R.id.checkBox_music)
        val checkboxsport= view.findViewById<CheckBox>(R.id.checkBox_sport)
        val checkboxgame = view.findViewById<CheckBox>(R.id.checkBox_game)

        when{
            hobbies!!.contains("Music") -> checkboxmusic.isChecked = true
            hobbies!!.contains("Sport") -> checkboxsport.isChecked = true
            hobbies!!.contains("Game") -> checkboxgame.isChecked = true


        }

    }
}