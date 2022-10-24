package com.example.cvv2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.example.cvv2.Entity.Experience
import com.example.cvv2.Repository.ExperienceRepository
import com.example.cvv2.utils.AppDataBase
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
private val pickImage = 100
private var imageUri: Uri? = null
lateinit var ImageView2: ImageView
class AddExperience : AppCompatActivity() {
    lateinit var dataBase: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)


    ImageView2 = findViewById(R.id.IVPreviewImage)
        dataBase = AppDataBase.getDatabase(this)
        val ExpDao : ExperienceRepository
        val Input_company_name : TextInputEditText=findViewById(R.id.Input_comp_name)
        val Input_company_adress : TextInputEditText=findViewById(R.id.Input_uni_adresse)
    val Input_end_date: TextInputEditText = findViewById(R.id.Input_end_date)
    val Input_start_date: TextInputEditText = findViewById(R.id.input_start_date)
        val saveBtn :Button = findViewById(R.id.save)
    //date
    ImageView2.setOnClickListener {
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

        saveBtn.setOnClickListener {
            val exp:Experience= Experience(
                0,
                1,
                Input_company_name.text.toString()
                ,Input_company_adress.text.toString()
                ,Input_start_date.text.toString()
                ,Input_end_date.text.toString())

           dataBase.ExperienceDao().insert(exp)



        }
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
        imageUri = data?.data
        ImageView2.setImageURI(imageUri)
    }

}
}