package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.parseJson
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.personalDataInfo
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.writePersonalData

import com.example.madalinbranea.myapplication.JsonParsing.LanguageData
import com.example.madalinbranea.myapplication.R
import kotlinx.android.synthetic.main.activity_element_editing.*
import kotlinx.android.synthetic.main.activity_personal.*

class ClientActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)

        back_button_client.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@ClientActivity, MainActivity::class.java)
            startActivity(intent)
        })

        parseJson(applicationContext)
        last_name.setText(personalDataInfo!!.LastName)
        first_name.setText(personalDataInfo!!.FirstName)
        age.setText(personalDataInfo!!.Age)
        last_school.setText(personalDataInfo!!.LastSchool)
        e_mail.setText((personalDataInfo!!.EMail))

        save_info_client.setOnClickListener(View.OnClickListener {

parseJson(applicationContext)
            personalDataInfo!!.LastName = last_name.text.toString()
            personalDataInfo!!.FirstName = first_name.text.toString()
            personalDataInfo!!.Age = age.text.toString()
            personalDataInfo!!.LastSchool = last_school.text.toString()
            personalDataInfo!!.EMail = e_mail.text.toString()
writePersonalData(applicationContext,filesDir.absolutePath+"/example.json", personalDataInfo!!)



            save_info_client.text = "Success"
        })



    }}