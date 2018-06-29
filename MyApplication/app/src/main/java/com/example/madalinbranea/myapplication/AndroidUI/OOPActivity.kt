package com.example.madalinbranea.myapplication.AndroidUI

import com.example.madalinbranea.myapplication.JsonParsing.JsonParser
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.madalinbranea.myapplication.R
import kotlinx.android.synthetic.main.activity_oop.*

class OOPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)

        BackButtonOop.setOnClickListener{ v ->
            val intent = Intent(this@OOPActivity, MainActivity::class.java)
            startActivity(intent)
        }

        java_data.setOnClickListener{ v ->
            val intent = Intent(this@OOPActivity, ElementActivity::class.java)
            intent.putExtra("Title","Java")
            intent.putExtra("category","oop")
            intent.putExtra("Domain","Java")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        cplus_data.setOnClickListener{ v ->
            val intent = Intent(this@OOPActivity, ElementActivity::class.java)
            intent.putExtra("Title","CPlus")
            intent.putExtra("Domain","CPlus")
            intent.putExtra("category","oop")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        python_data.setOnClickListener{ v ->
            val intent = Intent(this@OOPActivity, ElementActivity::class.java)
            intent.putExtra("Title","Python")
            intent.putExtra("Domain","Python")
            intent.putExtra("category","oop")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        csharp.setOnClickListener{ v ->
            val intent = Intent(this@OOPActivity, ElementActivity::class.java)
            intent.putExtra("Title","C#")
            intent.putExtra("Domain","C#")
            intent.putExtra("category","oop")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }



    }}