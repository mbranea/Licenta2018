package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser
import com.example.madalinbranea.myapplication.R
import kotlinx.android.synthetic.main.activity_oop.*
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_web)

    BackButtonWeb.setOnClickListener{ v ->
        val intent = Intent(this@WebActivity, MainActivity::class.java)
        startActivity(intent)
    }

    javascript.setOnClickListener{ v ->
        val intent = Intent(this@WebActivity, ElementActivity::class.java)
        intent.putExtra("Title","JavaScript")
        intent.putExtra("Domain", "JavaScript")
        intent.putExtra("category","web")
        JsonParser.parseJson(applicationContext)
        startActivity(intent)
    }
    html.setOnClickListener{ v ->
        val intent = Intent(this@WebActivity, ElementActivity::class.java)
        intent.putExtra("Title","Html")
        intent.putExtra("Domain", "HTML")
        intent.putExtra("category","web")
        JsonParser.parseJson(applicationContext)
        startActivity(intent)
    }
    premade.setOnClickListener{ v ->
        val intent = Intent(this@WebActivity, ElementActivity::class.java)
        intent.putExtra("Title","Premade Tools")
        intent.putExtra("Domain", "PRE")
        intent.putExtra("category","web")
        JsonParser.parseJson(applicationContext)
        startActivity(intent)
    }
    css.setOnClickListener{ v ->
        val intent = Intent(this@WebActivity, ElementActivity::class.java)
        intent.putExtra("Title","Css")
        intent.putExtra("Domain", "CSS")
        intent.putExtra("category","web")
        JsonParser.parseJson(applicationContext)
        startActivity(intent)
    }



}}