package com.example.cvv2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvv2.Entity.Experience
import com.example.cvv2.ListExperience.ExperienceAdapter
import com.example.cvv2.utils.AppDataBase
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [my_experience.newInstance] factory method to
 * create an instance of this fragment.
 */

class my_experience : Fragment(R.layout.fragment_my_experience) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recylcerexp: RecyclerView
    lateinit var recylcerExpAdapter: ExperienceAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_my_experience, container, false)

       val dataBase:AppDataBase= AppDataBase.getDatabase(this)
        recylcerexp = view.findViewById(R.id.RecyclerExperience)
        recylcerExpAdapter = ExperienceAdapter(Career.ExperienceList)
        recylcerexp.adapter = recylcerExpAdapter
        recylcerexp.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL ,false)
        return  view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment my_experience.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            my_experience().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}