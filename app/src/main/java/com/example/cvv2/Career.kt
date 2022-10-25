package com.example.cvv2


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.cvv2.Entity.Experience
import com.example.cvv2.ListExperience.ExperienceAdapter
import com.example.cvv2.utils.AppDataBase


class Career : AppCompatActivity() {
    lateinit var dataBase : AppDataBase
    companion object {
        lateinit var ExperienceList: MutableList<Experience>
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
val buttonexperience : Button = findViewById(R.id.buttonExperience)
val buttoneducation : Button = findViewById(R.id.buttonEducation)
     /*   val menu : Menu =findViewById(R.id.menu)
        val exp_item : MenuItem =menu.getItem(1)

   onMenuItemSelected(1,exp_item)
*/
        dataBase = AppDataBase.getDatabase(this)
        //TODO 12 "Get All champions from dataBase"
        ExperienceList = dataBase.ExperienceDao().getAllExperience() as MutableList<Experience>


        val experiencefragment :my_experience=my_experience.newInstance("","")
        val educationfragment :my_education=my_education.newInstance("","")
   val tool_bar_back : Toolbar = findViewById(R.id.bar_career)
   tool_bar_back.setNavigationOnClickListener{
       finish()
   }
        tool_bar_back.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.experience -> {
                    val intent = Intent(this, AddExperience::class.java)
                    startActivity(intent)
                    true
                }
                R.id.education -> {
                    val intent = Intent(this, AddEducation::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.relativeLayout2,experiencefragment)
            commit()
        }

        buttoneducation.setOnClickListener {

           supportFragmentManager.beginTransaction().apply {

                replace(R.id.relativeLayout2, educationfragment)
                commit()
            }
        }
        buttonexperience.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {

                replace(R.id.relativeLayout2, experiencefragment)
                commit()
            }
        }
    }

    /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu_experience, menu)
         return super.onCreateOptionsMenu(menu)
     }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
         println("+++++++++++++++++++++++"+item.itemId)
         when (item.itemId) {
             1 ->{
                 val intent = Intent(this, AddExperience::class.java)
                 startActivity(intent)
             }
             2 ->{
                 val intent = Intent(this, AddEducation::class.java)
                 startActivity(intent)
             }


         }
         return super.onOptionsItemSelected(item)
     }*/
   // override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
  //      super.onActivityResult(requestCode, resultCode, data)
  //  }
    override fun onResume() {
        supportFragmentManager.beginTransaction().apply {
            val experiencefragment :my_experience=my_experience.newInstance("","")
            replace(R.id.relativeLayout2,experiencefragment)
            commit()
        }
        super.onResume()
    }
}