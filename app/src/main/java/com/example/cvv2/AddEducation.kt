package com.example.cvv2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
private val pickImage = 100
private var imageUri: Uri? = null
lateinit var ImageView1: ImageView
class AddEducation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_education)

        ImageView1 = findViewById(R.id.IVPreviewImage)
        val Input_end_date: TextInputEditText = findViewById(R.id.Input_end_date)
        val Input_start_date: TextInputEditText = findViewById(R.id.input_start_date)
        val save_button : Button = findViewById(R.id.save)
        //date
        val toolbar : MaterialToolbar =findViewById(R.id.topAppBar)
        toolbar.setNavigationOnClickListener{
            finish()
        }
        ImageView1.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }
//
        val datePicker1 =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()
        val datePicker2 =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()




        Input_end_date.setOnClickListener {
            if (datePicker1 != null && !datePicker1.isAdded()) {
                datePicker1.show(supportFragmentManager, "tag")
                datePicker1.addOnPositiveButtonClickListener {
                    Input_end_date.setText("" + datePicker1.headerText)
                }
            }
        }
        Input_start_date.setOnClickListener {
            if (datePicker2 != null && !datePicker2.isAdded()) {
                datePicker2.show(supportFragmentManager, "tag2")

                datePicker2.addOnPositiveButtonClickListener {
                    Input_start_date.setText("" + datePicker2.headerText)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            ImageView1.setImageURI(imageUri)
        }

    }
}


