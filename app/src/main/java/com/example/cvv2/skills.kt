package com.example.cvv2

import android.content.Intent
import android.content.Intent.getIntent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity




class skills : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)
        val androidSkill = findViewById<SeekBar>(R.id.seekBar_android)
        val iosSkill = findViewById<SeekBar>(R.id.seekBar_ios)
        val flutterSkill = findViewById<SeekBar>(R.id.seekBar_flutter)
        val arabic = findViewById<CheckBox>(R.id.checkBox_arabic)
        val french = findViewById<CheckBox>(R.id.checkbox_french)
        val english = findViewById<CheckBox>(R.id.checkBox_english)
        val music = findViewById<CheckBox>(R.id.checkBox_music)
        val sport = findViewById<CheckBox>(R.id.checkBox_sport)
        val games = findViewById<CheckBox>(R.id.checkBox_game)
        val submit = findViewById<Button>(R.id.SUBMIT)

        val intent = intent
        val name = intent.getStringExtra("Username")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val genre = intent.getStringExtra("Gender")
        val imagestring = intent.getStringExtra("Image")

        submit.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val lang = when {
                arabic.isChecked && french.isChecked && english.isChecked -> "Arabic French English"
                arabic.isChecked && french.isChecked -> "Arabic French"
                arabic.isChecked && english.isChecked -> "Arabic English"
                french.isChecked && english.isChecked -> "French English"
                arabic.isChecked -> "Arabic"
                french.isChecked -> "French"
                english.isChecked -> "English"

                else -> "None"
            }
            val hb = when {
                music.isChecked && sport.isChecked && games.isChecked -> "Music Sport Games"
                sport.isChecked && games.isChecked -> "Sport Games"
                sport.isChecked && music.isChecked -> "Sport Music"
                games.isChecked && music.isChecked -> "Games Music"
                games.isChecked -> "Games"
                sport.isChecked -> "Sport"
                music.isChecked -> "Music"
                else -> "None"
            }

            intent.putExtra("Android", androidSkill.progress)
            intent.putExtra("iOS", iosSkill.progress)
            intent.putExtra("Flutter", flutterSkill.progress)
            intent.putExtra("Language", lang)
            intent.putExtra("Hobbies", hb)
            intent.putExtra("Name", name)
            intent.putExtra("Age", age)
            intent.putExtra("Email", mail)
            intent.putExtra("Gender", genre)
            intent.putExtra("Image",imagestring)
            startActivity(intent)
        }
    }
    }
