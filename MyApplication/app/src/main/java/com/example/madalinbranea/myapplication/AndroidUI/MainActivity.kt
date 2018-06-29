package com.example.madalinbranea.myapplication.AndroidUI

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

import com.example.madalinbranea.myapplication.ClientSideManagement.PreClient
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser
import com.example.madalinbranea.myapplication.R
import java.io.File


class MainActivity : AppCompatActivity() {

    val TAG = "ContentValues"
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        functional_data.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, FunctionalActivity::class.java)
            startActivity(intent)
        }
        infrastructure_data.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, InfrastructureActivity::class.java)
            startActivity(intent)
        }
        mobile_data.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, MobileActivity::class.java)
            startActivity(intent)
        }
        web_data.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, WebActivity::class.java)
            startActivity(intent)
        }
        personal_data.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, ClientActivity::class.java)
            startActivity(intent)
        }
        oop_data.setOnClickListener { v ->
            val intent = Intent(this@MainActivity, OOPActivity::class.java)
            startActivity(intent)
        }
        PdfButton.setOnClickListener { v ->
JsonParser.parseJson(applicationContext)
           AsyncTaskExample().execute();
showDialog(this,"Skills generated", "The requested Matrix has been sent to the e-mail adress : "+ JsonParser.personalDataInfo!!.EMail)
           // thread()
          // {
         //      PreClient.send(PreClient.getStringFromFile(applicationContext.filesDir.absolutePath + File.separator + "example.json"));

          //  }

        }


    }
    fun showDialog(activity: Activity,  title: String,  message: CharSequence) {
        var builder  =  AlertDialog.Builder(activity);

        if (title != null) builder.setTitle(title);

        builder.setMessage(message);
        builder.setPositiveButton("OK", null);

        builder.show();
    }
    inner class AsyncTaskExample: AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()

        }

        override fun doInBackground(vararg p0: String?) :String{


            try {
                PreClient.send(PreClient.getStringFromFile(applicationContext.filesDir.absolutePath + File.separator + "example.json"));

            } catch(Ex: Exception) {
                Log.e(TAG, Ex.toString());
            }
            Log.e(TAG,"success");
            return "success"
        }

        override fun onPostExecute(result: String?) {

        }
    }



    }