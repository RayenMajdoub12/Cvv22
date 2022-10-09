package com.example.cvv2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.provider.MediaStore
import android.util.Patterns
import android.widget.Button
import android.widget.Gallery
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup

import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

private val pickImage = 100
private var imageUri: Uri? = null
lateinit var imageView: ImageView
lateinit var button: Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       button = findViewById(R.id.BSelectImage)
         imageView = findViewById(R.id.IVPreviewImage)
        //input
        val name = findViewById<TextInputEditText>(R.id.NameInput)
        val email = findViewById<TextInputEditText>(R.id.emailInput)
        val age = findViewById<TextInputEditText>(R.id.AgeInput)
        val next_button=findViewById<Button>(R.id.nextbutton)
        //layout
        val namelayout = findViewById<TextInputLayout>(R.id.outlined_username)
        val emaillayout = findViewById<TextInputLayout>(R.id.outlined_email)
        val agelayout = findViewById<TextInputLayout>(R.id.outlined_age)
        val GenderGroup = findViewById<RadioGroup>(R.id.RadioGroup)
        val groupe = GenderGroup.checkedRadioButtonId
        val FM = findViewById<RadioButton>(groupe)
         val pickImage = 100
         var imageUri: Uri? = null
        button.setOnClickListener {
          val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
          startActivityForResult(gallery, pickImage)

      }


        when {
            email.text!!.isEmpty()->next_button.isEnabled = false
            age.text!!.isEmpty()->next_button.isEnabled= false
            name.text!!.isEmpty()->next_button.isEnabled= false
        }

        name.doOnTextChanged { text, start, before, count ->

            if(text!!.isEmpty())
            {
                namelayout.error = "Must not be empty "
                next_button.isEnabled=false

            }else
            {
                namelayout.error = null
                next_button.isEnabled =!(email.text!!.isEmpty() && age.text!!.isEmpty())
            }
        }
        email.doOnTextChanged { text, start, before, count ->
            if (Patterns.EMAIL_ADDRESS.matcher(email.text.toString())
                    .matches()
            ) {
                next_button.isEnabled = true
                emaillayout.error = null
            }
            else if (text!!.isEmpty()) {
                emaillayout.error = "Must not be empty!"
                next_button.isEnabled=false
            }
            else {
                emaillayout.error = null
                email.setError("Check your mail")
                next_button.isEnabled = !(age.text!!.isEmpty() && name.text!!.isEmpty())


            }
        }
        age.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                agelayout.error = "Must not be empty!"
                 next_button.isEnabled = false
            } else if (text.length >= 3) {
                agelayout.error = "Age is wrong!"
                next_button.isEnabled = false
            } else {
                agelayout.error = null
                next_button.isEnabled = !(email.text!!.isEmpty() && name.text!!.isEmpty())
            }
        }

        next_button.setOnClickListener {

            val fullname = name.text.toString()
            val ageV2 = age.text.toString()
            val mail = email.text.toString()
            val genre = FM.text.toString()
            val image = imageView

            val intent = Intent(this, skills::class.java)
            intent.putExtra("Username", fullname)
            intent.putExtra("Email", mail)
            intent.putExtra("Age", ageV2)
            intent.putExtra("Gender", genre)

            startActivity(intent)

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
        }

    }
}
