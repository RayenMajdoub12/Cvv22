package com.example.cvv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

//intent
        val intent = intent
        val FullName = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val androidskill = intent.getIntExtra("Android",0)
        val iosSkill = intent.getIntExtra("iOS",0)
        val flutterskill = intent.getIntExtra("Flutter",0)
        val language = intent.getStringExtra("Language")
        val hbs = intent.getStringExtra("Hobbies")
        val image = intent.getStringExtra("Image")!!.toUri()
        val buttoncareer = findViewById<Button>(R.id.buttoncareer)
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+hbs+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

        val name = findViewById<TextView>(R.id.Name)
        val email = findViewById<TextView>(R.id.Email)
        //buttons
        val button_h=findViewById<Button>(R.id.button_h)
        val button_s=findViewById<Button>(R.id.button_s)
        val button_l=findViewById<Button>(R.id.button_l)
        //fragments and bundles


        val firstfargment=Fragment_Hobbies.newInstance(hbs.toString(),"")

        //skills
        val secondfragment=Fragment_Skills.newInstance(androidskill,iosSkill,flutterskill)

        //lang
        val thirdfragment =Fragment_Lang.newInstance(language.toString(),"")



        //fragments manager
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView3,firstfargment)
            commit()
        }

        button_h.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fragmentContainerView3, firstfargment)
                commit()
            }
        }
            button_s.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {

                    replace(R.id.fragmentContainerView3, secondfragment)
                    commit()
                }
            }
                button_l.setOnClickListener {
                    supportFragmentManager.beginTransaction().apply {

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

        buttoncareer.setOnClickListener {


            val intent = Intent(this, Career::class.java)
            startActivity(intent)

        }
                }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = intent
        val FullName = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val fourthfragment = AboutMeFragment.newInstance(FullName.toString(),age.toString(),gender.toString(),mail.toString())
        when (item.itemId) {
            R.id.info -> supportFragmentManager.beginTransaction().apply {

                replace(R.id.fragmentContainerView3, fourthfragment)
                commit()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
