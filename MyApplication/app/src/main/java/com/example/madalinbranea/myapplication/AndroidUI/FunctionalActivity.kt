package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser
import com.example.madalinbranea.myapplication.R
import kotlinx.android.synthetic.main.activity_functional.*
import kotlinx.android.synthetic.main.activity_oop.*


class FunctionalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functional)

        BackButtonFunctional.setOnClickListener{ v ->
            val intent = Intent(this@FunctionalActivity, MainActivity::class.java)
            startActivity(intent)
        }
        haskell.setOnClickListener{ v ->
            val intent = Intent(this@FunctionalActivity, ElementActivity::class.java)
            intent.putExtra("Title","Haskell")
            intent.putExtra("Domain","Haskell")
            intent.putExtra("category","functional")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        perl.setOnClickListener{ v ->
            val intent = Intent(this@FunctionalActivity, ElementActivity::class.java)
            intent.putExtra("Title","Perl")
            intent.putExtra("Domain","Perl")
            intent.putExtra("category","functional")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        lisp.setOnClickListener{ v ->
            val intent = Intent(this@FunctionalActivity, ElementActivity::class.java)
            intent.putExtra("Title","Lisp")
            intent.putExtra("Domain","Lisp")
            intent.putExtra("category","functional")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }
        erlang.setOnClickListener{ v ->
            val intent = Intent(this@FunctionalActivity, ElementActivity::class.java)
            intent.putExtra("Title","Erlang")
            intent.putExtra("Domain","Erlang")
            intent.putExtra("category","functional")
            JsonParser.parseJson(applicationContext)
            startActivity(intent)
        }




    }}