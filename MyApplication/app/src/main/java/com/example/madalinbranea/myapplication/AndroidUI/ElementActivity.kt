package com.example.madalinbranea.myapplication.AndroidUI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.madalinbranea.myapplication.AndroidUI.RemoveHelper.removeAllChildViews
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.android_fsDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.android_fsUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.android_osDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.android_osUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.android_uiDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.android_uiUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.antDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.antUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.charpDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.cppDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.cppUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.csharpUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.cssDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.cssUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.erlangDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.erlangUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.gradleDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.gradleUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.haskellDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.haskellUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.htmlDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.htmlUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.jScriptUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.javaDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.javaScriptDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.javaUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.lispDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.lispUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.mavenDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.mavenUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.perlDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.perlUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.premadeDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.premadeUnused
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.pythonDataList
import com.example.madalinbranea.myapplication.JsonParsing.JsonParser.pythonUnused
import com.example.madalinbranea.myapplication.JsonParsing.LanguageData
import com.example.madalinbranea.myapplication.R
import com.yarolegovich.mp.MaterialRightIconPreference
import kotlinx.android.synthetic.main.activity_element.*
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.element_layouts.*


class ElementActivity : AppCompatActivity() {

var domain = ""
    val TAG = "ContentValues"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element)
        BackButtonElement.setOnClickListener{ v ->
            val intent = Intent(this@ElementActivity, MainActivity::class.java)
            startActivity(intent)
        }
        if (!isTaskRoot()) {
            intent = getIntent();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(intent.getAction())) {
                Log.w(TAG, "Main Activity is not the root.  Finishing Main Activity instead of launching.");
                finish();
                return;
            }
        }

        javaUnused.clear()
        javaUnused.addAll(javaDataList)
        cppUnused.clear()
        cppUnused.addAll(cppDataList)
        jScriptUnused.clear()
        jScriptUnused.addAll(javaScriptDataList)
        htmlUnused.clear()
        htmlUnused.addAll(htmlDataList)
        cssUnused.clear()
        cssUnused.addAll(cssDataList)
        premadeUnused.clear()
        premadeUnused.addAll(premadeDataList)
        pythonUnused.clear()
        pythonUnused.addAll(pythonDataList)
        csharpUnused.clear()
        csharpUnused.addAll(charpDataList)
        haskellUnused.clear()
        haskellUnused.addAll(haskellDataList)
        perlUnused.clear()
        perlUnused.addAll(perlDataList)
        erlangUnused.clear()
        erlangUnused.addAll(erlangDataList)
        lispUnused.clear()
        lispUnused.addAll(lispDataList)
        mavenUnused.clear()
        mavenUnused.addAll(mavenDataList)
        gradleUnused.clear()
        gradleUnused.addAll(gradleDataList)
        antUnused.clear()
        antUnused.addAll(antDataList)
        android_uiUnused.clear()
        android_uiUnused.addAll(android_uiDataList)
        android_osUnused.clear()
        android_osUnused.addAll(android_osDataList)
        android_fsUnused.clear()
        android_fsUnused.addAll(android_fsDataList)




        var Title: String = intent.getStringExtra("Title")
         domain = intent.getStringExtra("Domain")
        this.setTitle(Title)


        add_new.setOnClickListener { v ->


         // drawNewElement("title")
            val intent2 = Intent(this@ElementActivity, EditActivity::class.java)
            intent2.putExtra("Domain",intent.getStringExtra("Domain"))
            intent2.putExtra("element_name","new Element")
            intent2.putExtra("type","Create")
            intent2.putExtra("category",intent.getStringExtra("category"))
            startActivity(intent2)

        }
        syncDb()
    }

    override fun onResume() {
        super.onResume()
       // removeAllChildViews(overview2)
       //overview2.removeAllViews()
        syncDb()
    }

    override fun onRestart() {
        super.onRestart()
       // overview2.removeAllViews()
       //removeAllChildViews(overview2)
        syncDb()
    }

    fun syncDb() {

         domain = intent.getStringExtra("Domain")

        operateDomainForSync("Java",domain, javaUnused)
        operateDomainForSync("CPlus",domain, cppUnused)
        operateDomainForSync("JavaScript",domain, jScriptUnused)
        operateDomainForSync("HTML",domain, htmlUnused)
        operateDomainForSync("CSS",domain, cssUnused)
        operateDomainForSync("PRE",domain, premadeUnused)
        operateDomainForSync("Python",domain, pythonUnused)
        operateDomainForSync("CSharp",domain, csharpUnused)
        operateDomainForSync("Haskell",domain, haskellUnused)
        operateDomainForSync("Perl",domain, perlUnused)
        operateDomainForSync("Erlang",domain, erlangUnused)
        operateDomainForSync("Lisp",domain, lispUnused)
        operateDomainForSync("Maven",domain, mavenUnused)
        operateDomainForSync("Gradle",domain, gradleUnused)
        operateDomainForSync("Ant",domain, antUnused)
        operateDomainForSync("Android_UI",domain, android_uiUnused)
        operateDomainForSync("Android_OS",domain, android_osUnused)
        operateDomainForSync("Android_FS",domain, android_fsUnused)




    }

    fun operateDomainForSync(requestedDomain:String,domain:String,list:ArrayList<LanguageData>)
    {
if(domain.equals(requestedDomain))
{
    list.forEach { it: LanguageData -> drawNewElement(it.elementName)}
    list.clear()
}
    }


    fun drawNewElement(title: String?) {


        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val element = inflater.inflate(R.layout.element_layouts, overview2, false)
        (element as MaterialRightIconPreference).setTitle(title) // sau element.findViewById(R.id.new_element1).setTitle(title)
        overview2.addView(element) // vezi exact cum e functia, sper ca asa

        element.setOnClickListener {

            val intent2 = Intent(this@ElementActivity, EditActivity::class.java)
            //intent2.putExtra("Domain",intent.getStringExtra("Domain"))
            if (element.title != null) {
                intent2.putExtra("element_name", element.title)
                intent2.putExtra("Domain", domain)
                intent2.putExtra("type","Edit")
                intent2.putExtra("category",intent.getStringExtra("category"))
            }
            overview2.removeView(element)
            startActivity(intent2)
        }


    }




}

