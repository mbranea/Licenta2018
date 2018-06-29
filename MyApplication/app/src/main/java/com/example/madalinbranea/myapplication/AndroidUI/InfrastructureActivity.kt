package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser
import com.example.madalinbranea.myapplication.R
import kotlinx.android.synthetic.main.activity_functional.*
import kotlinx.android.synthetic.main.activity_infrastructure.*


class InfrastructureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infrastructure)

        BackButtonInfrastructure.setOnClickListener{ v ->
            val intent = Intent(this@InfrastructureActivity, MainActivity::class.java)
            startActivity(intent)
        }

        maven.setOnClickListener{ v ->
            val intent = Intent(this@InfrastructureActivity, ElementActivity::class.java)
            intent.putExtra("Title","Maven")
            intent.putExtra("Domain","Maven")
            intent.putExtra("category","infrastructure")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        gradle.setOnClickListener{ v ->
            val intent = Intent(this@InfrastructureActivity, ElementActivity::class.java)
            intent.putExtra("Title","Gradle")
            intent.putExtra("Domain","Gradle")
            intent.putExtra("category","infrastructure")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        ant.setOnClickListener{ v ->
            val intent = Intent(this@InfrastructureActivity, ElementActivity::class.java)
            intent.putExtra("Title","Ant")
            intent.putExtra("Domain","Ant")
            intent.putExtra("category","infrastructure")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
    }}