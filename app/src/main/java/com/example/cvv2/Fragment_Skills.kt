package com.example.cvv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
  private var param1: Int? = null
private var param2: Int? = null
private var param3: Int? = null
class Fragment_Skills : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: Int? = null
    private var param3: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment__skills, container, false)
        val Android: SeekBar = view.findViewById(R.id.seekBar_android)
        val ios: SeekBar = view.findViewById(R.id.seekBar_ios)
        val flutter: SeekBar = view.findViewById(R.id.seekBar_flutter)


        Android.isEnabled=false
        ios.isEnabled=false
        flutter.isEnabled=false

        Android.setProgress(arguments?.getInt(ARG_PARAM1)!!,true)
        ios.setProgress(arguments?.getInt(ARG_PARAM2)!!,true)
        flutter.setProgress(arguments?.getInt(ARG_PARAM3)!!,true)

        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: Int , param3 :Int) =
            Fragment_Skills().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                    putInt(ARG_PARAM3, param3)
                }
            }
    }
}