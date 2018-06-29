package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View


import com.example.madalinbranea.myapplication.JsonParsing.LanguageData
import kotlinx.android.synthetic.main.activity_element_editing.*
import java.io.FileInputStream
import java.io.InputStream
import android.util.Log
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.editJsonElement
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.languageItemArray
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.writeNewToJsonArray
import com.example.madalinbranea.myapplication.R

class EditActivity : AppCompatActivity()
{
    val TAG = "ContentValues"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element_editing)
        var currentItem  = findInJson(intent.getStringExtra("element_name"))



        var domain = intent.getStringExtra("Domain")


back_button_editing.setOnClickListener(View.OnClickListener {
if(intent.getStringExtra("category")=="oop")
{
    val intent = Intent(this@EditActivity, OOPActivity::class.java)
    startActivity(intent)
}
    if(intent.getStringExtra("category")=="web")
    {
        val intent = Intent(this@EditActivity, WebActivity::class.java)
        startActivity(intent)
    }
    if(intent.getStringExtra("category")=="mobile")
    {
        val intent = Intent(this@EditActivity, MobileActivity::class.java)
        startActivity(intent)
    }
    if(intent.getStringExtra("category")=="functional")
    {
        val intent = Intent(this@EditActivity, FunctionalActivity::class.java)
        startActivity(intent)
    }
    if(intent.getStringExtra("category")=="infrastructure")
    {
        val intent = Intent(this@EditActivity, InfrastructureActivity::class.java)
        startActivity(intent)
    }


})

save_info.setOnClickListener(View.OnClickListener {



    if(intent.getStringExtra("type")=="Edit") {
        editJsonElement(applicationContext, filesDir.absolutePath + "/example.json", currentItem.elementName.toString(),LanguageData(element_name.text.toString(), duration.text.toString(), appraisal.text.toString(), your_comments.text.toString()), domain);
    }else {


        writeNewToJsonArray(applicationContext, filesDir.absolutePath + "/example.json", LanguageData(element_name.text.toString(), duration.text.toString(), appraisal.text.toString(), your_comments.text.toString()), domain)
    }

    currentItem.elementName=element_name.text.toString()
    currentItem.duration=duration.text.toString()
    currentItem.appraisal=appraisal.text.toString()
    currentItem.Comments=your_comments.text.toString()
        var input : InputStream = FileInputStream(filesDir.absolutePath+"/example.json")

save_info.text = "Success"
})

        duration.setText(currentItem.duration)
        appraisal.setText(currentItem.appraisal)
        your_comments.setText(currentItem.Comments)
        element_name.setText(currentItem.elementName)

    }

    fun convertStreamToString(`is`: java.io.InputStream): String {
        try {
            return java.util.Scanner(`is`).useDelimiter("\\A").next()
        } catch (e: java.util.NoSuchElementException) {
            return ""
        }

    }




    fun  findInJson(name:String) : LanguageData
    {
      for(it in languageItemArray)
      {
          if (it.elementName.equals(name))
          {
            return it
          }
      }
return LanguageData()
    }

}