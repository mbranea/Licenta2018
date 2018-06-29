package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser
import com.example.madalinbranea.myapplication.R
import kotlinx.android.synthetic.main.activity_mobile.*
import kotlinx.android.synthetic.main.activity_oop.*

class MobileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile)

        BackButtonMobile.setOnClickListener{ v ->
            val intent = Intent(this@MobileActivity, MainActivity::class.java)
            startActivity(intent)
        }


        android_ui.setOnClickListener{ v ->
            val intent = Intent(this@MobileActivity, ElementActivity::class.java)
            intent.putExtra("Title","Android_UI")
            intent.putExtra("Domain","Android_UI")
            intent.putExtra("category","mobile")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        android_os.setOnClickListener{ v ->
            val intent = Intent(this@MobileActivity, ElementActivity::class.java)
            intent.putExtra("Title","Android_OS")
            intent.putExtra("Domain","Android_OS")
            intent.putExtra("category","mobile")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        android_fs.setOnClickListener{ v ->
            val intent = Intent(this@MobileActivity, ElementActivity::class.java)
            intent.putExtra("Title","Android_FS")
            intent.putExtra("Domain","Android_FS")
            intent.putExtra("category","mobile")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }


    }}