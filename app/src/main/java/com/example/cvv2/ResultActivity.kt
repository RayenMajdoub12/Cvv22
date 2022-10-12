package com.example.cvv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
//intent
        val intent = intent
        val FullName = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val androidskill = intent.getStringExtra("Android")
        val iosSkill = intent.getStringExtra("iOS")
        val flutterskill = intent.getStringExtra("Flutter")
        val language = intent.getStringExtra("Language")
        val hbs = intent.getStringExtra("Hobbies")
        val image = intent.getStringExtra("Image")!!.toUri()
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+hbs+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

        val name = findViewById<TextView>(R.id.Name)
        val email = findViewById<TextView>(R.id.Email)
        //buttons
        val button_h=findViewById<Button>(R.id.button_h)
        val button_s=findViewById<Button>(R.id.button_s)
        val button_l=findViewById<Button>(R.id.button_l)
        //fragments and bundles
        //bundle hobbie
        val firstfargment=Fragment_Hobbies()
        //skills
        val secondfragment=Fragment_Skills()

        //lang
        val thirdfragment =Fragment_Lang()


        //fragments manager
        supportFragmentManager.beginTransaction().apply {

            val hBundle = Bundle()
            hBundle.putString("Hobbies",hbs)
            firstfargment.arguments = hBundle
            replace(R.id.fragmentContainerView3,firstfargment)
            commit()

        }
        button_h.setOnClickListener {


            supportFragmentManager.beginTransaction().apply {
                val hBundle = Bundle()
                hBundle.putString("Hobbies",hbs)
                firstfargment.arguments = hBundle
                replace(R.id.fragmentContainerView3, firstfargment)
                commit()
            }
        }
            button_s.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    val sBundle = Bundle()
                    sBundle.putString("Android",androidskill)
                    sBundle.putString("iOS",iosSkill)
                    sBundle.putString("Flutter",flutterskill)
                    secondfragment.arguments = sBundle
                    replace(R.id.fragmentContainerView3, secondfragment)
                    commit()
                }
            }
                button_l.setOnClickListener {
                    supportFragmentManager.beginTransaction().apply {
                        val lBundle = Bundle()
                        lBundle.putString("Language",language)
                        firstfargment.arguments = lBundle
                        replace(R.id.fragmentContainerView3, thirdfragment)
                        commit()
                    }}





                    /*   val yearold= findViewById<TextView>(R.id.yearsold)
        val genre= findViewById<TextView>(R.id.genre)
        val android= findViewById<TextView>(R.id.android_skill)
        val ios= findViewById<TextView>(R.id.iOS_skill)
        val flutter= findViewById<TextView>(R.id.Flutter_skill)
        val lang= findViewById<TextView>(R.id.Languages)
        val hobbies= findViewById<TextView>(R.id.hobbies)*/
                    val imageview = findViewById<ImageView>(R.id.imageView2)
                    name.text = "Name:$FullName"
                    email.text = "Email:$mail"
                    /*   yearold.text="Age:$age"
        genre.text="Gender:$gender"
        android.text="AndroidSkill:$androidskill"
        ios.text="IosSkill:$iosSkill"
        flutter.text="FlutterSkill:$flutterskill"
        lang.text="Languages:$language"
        hobbies.text="Hobbies:$hbs"*/
                    imageview.setImageURI(image)
                }
            }