package com.example.madalinbranea.myapplication.JsonParsing

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.io.InputStream


object JsonParser {
    var languageItemArray = ArrayList<LanguageData>()

     var personalDataInfo: PersonalData? = null

     var javaDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var cppDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var htmlDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var cssDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var premadeDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var pythonDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var charpDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var haskellDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var perlDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var erlangDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var lispDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var mavenDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var gradleDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var javaScriptDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var antDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var android_uiDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var android_osDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var android_fsDataList: ArrayList<LanguageData> = ArrayList<LanguageData>()




    var cvData :CVData?=CVData();

    var javaUnused:ArrayList<LanguageData> = ArrayList()
    var cppUnused:ArrayList<LanguageData> = ArrayList()
    var jScriptUnused:ArrayList<LanguageData> = ArrayList()
    var htmlUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var cssUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var premadeUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var pythonUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var csharpUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var haskellUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var perlUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var erlangUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var lispUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var mavenUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var gradleUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var antUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var android_uiUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var android_osUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()
    var android_fsUnused: ArrayList<LanguageData> = ArrayList<LanguageData>()

    fun parseJson(context: Context)
    {
        var gson = Gson()

        try {

            // val inputStream:InputStream = context.assets.open("example.json")
            val inputStream: InputStream = FileInputStream(context.filesDir.absolutePath + File.separator + "example.json")

            val inputString = inputStream.bufferedReader().use { it.readText() }
            cvData = gson.fromJson(inputString, CVData::class.java)


            if (cvData != null) {
                personalDataInfo = cvData!!.Personal
                javaDataList = this.generaliseItems(cvData!!.javaData)
                cppDataList = this.generaliseItems(cvData!!.CData)
                javaScriptDataList = this.generaliseItems((cvData!!.jScriptData))
                htmlDataList = this.generaliseItems((cvData!!.htmlData))
                cssDataList = this.generaliseItems((cvData!!.cssData))
                premadeDataList = this.generaliseItems((cvData!!.premadeData))
                pythonDataList = this.generaliseItems((cvData!!.pythonData))
                charpDataList = this.generaliseItems((cvData!!.csharpData))
                haskellDataList = this.generaliseItems((cvData!!.haskellData))
                perlDataList = this.generaliseItems((cvData!!.perlData))
                erlangDataList = this.generaliseItems((cvData!!.erlangData))
                lispDataList = this.generaliseItems((cvData!!.lispData))
                mavenDataList = this.generaliseItems((cvData!!.mavenData))
                gradleDataList = this.generaliseItems((cvData!!.gradleData))

                antDataList = this.generaliseItems((cvData!!.antData))
                android_uiDataList = this.generaliseItems((cvData!!.android_uiData))
                android_osDataList = this.generaliseItems((cvData!!.android_osData))
                android_fsDataList = this.generaliseItems((cvData!!.android_fileSystemData))
                generateUnifiedList()





        }

        } catch (e:Exception){
            Log.d(TAG, e.toString())
        }

    }

    private fun generateUnifiedList() {
        languageItemArray.addAll(javaDataList)
        languageItemArray.addAll(cppDataList)
        languageItemArray.addAll(htmlDataList)
        languageItemArray.addAll(cssDataList)
        languageItemArray.addAll(premadeDataList)
        languageItemArray.addAll(pythonDataList)
        languageItemArray.addAll(charpDataList)
        languageItemArray.addAll(haskellDataList)
        languageItemArray.addAll(perlDataList)
        languageItemArray.addAll(erlangDataList)
        languageItemArray.addAll(lispDataList)
        languageItemArray.addAll(mavenDataList)
        languageItemArray.addAll(gradleDataList)
        languageItemArray.addAll(javaScriptDataList)
        languageItemArray.addAll(antDataList)
        languageItemArray.addAll(android_uiDataList)
        languageItemArray.addAll(android_osDataList)
        languageItemArray.addAll(android_fsDataList)






    }

    fun generaliseItems(list: java.util.ArrayList<LanguageData>):ArrayList<LanguageData>
    {
        var generalList: ArrayList<LanguageData> = ArrayList();

        for(it in list)
        {
            generalList.add(it as LanguageData)
        }
        return generalList
    }
    fun writePersonalData(context : Context, path: String?, data: PersonalData)
    {
        cvData!!.personal.Age = data.Age
        cvData!!.personal.FirstName= data.FirstName
        cvData!!.personal.LastName = data.LastName
        cvData!!.personal.LastSchool = data.LastSchool
        cvData!!.personal.EMail = data.EMail
        val writer: FileWriter = FileWriter(path);
        var gson = Gson()
        var json = gson.toJson(cvData);
        writer.write(json);
        writer.flush();
        writer.close();
        parseJson(context);

    }
    fun writeNewToJsonArray(context: Context, path: String?, data: LanguageData, domain: String) {
        operateDomainForAdd( "Java",domain, cvData!!.javaData,data)
        operateDomainForAdd("CPlus",domain, cvData!!.cData,data)
        operateDomainForAdd("JavaScript",domain, cvData!!.jScriptData,data)
        operateDomainForAdd("HTML",domain, cvData!!.htmlData,data)
        operateDomainForAdd("CSS",domain, cvData!!.cssData,data)
        operateDomainForAdd("PRE",domain, cvData!!.premadeData,data)
        operateDomainForAdd("Python",domain, cvData!!.pythonData,data)
        operateDomainForAdd("C#",domain, cvData!!.csharpData,data)
        operateDomainForAdd("Haskell",domain, cvData!!.haskellData,data)
        operateDomainForAdd("Perl",domain, cvData!!.perlData,data)
        operateDomainForAdd("Erlang",domain, cvData!!.erlangData,data)
        operateDomainForAdd("Lisp",domain, cvData!!.lispData,data)
        operateDomainForAdd("Maven",domain, cvData!!.mavenData,data)
        operateDomainForAdd("Ant",domain, cvData!!.antData,data)
        operateDomainForAdd("Android_UI",domain, cvData!!.android_uiData,data)
        operateDomainForAdd("Android_OS",domain, cvData!!.android_osData,data)
        operateDomainForAdd("Android_FS",domain, cvData!!.android_fileSystemData,data)


            val writer: FileWriter = FileWriter(path);
            var gson = Gson()
            var json = gson.toJson(cvData);

            writer.write(json);
            writer.flush();
            writer.close();
            parseJson(context);

    }
    fun editJsonElement(context: Context, path: String?,elementName:String, data: LanguageData, domain: String) {
        operateDomainForEdit("Java",domain, cvData!!.javaData,data,elementName)
        operateDomainForEdit("CPlus",domain, cvData!!.cData,data,elementName)
        operateDomainForEdit("JavaScript",domain, cvData!!.jScriptData,data,elementName)
        operateDomainForEdit("HTML",domain, cvData!!.htmlData,data,elementName)
        operateDomainForEdit("CSS",domain, cvData!!.cssData,data,elementName)
        operateDomainForEdit("PRE",domain, cvData!!.premadeData,data,elementName)
        operateDomainForEdit("Python",domain, cvData!!.pythonData,data,elementName)
        operateDomainForEdit("C#",domain, cvData!!.csharpData,data,elementName)
        operateDomainForEdit("Haskell",domain, cvData!!.haskellData,data,elementName)
        operateDomainForEdit("Perl",domain, cvData!!.perlData,data,elementName)
        operateDomainForEdit("Erlang",domain, cvData!!.erlangData,data,elementName)
        operateDomainForEdit("Lisp",domain, cvData!!.lispData,data,elementName)
        operateDomainForEdit("Maven",domain, cvData!!.mavenData,data,elementName)
        operateDomainForEdit("Ant",domain, cvData!!.antData,data,elementName)
        operateDomainForEdit("Android_UI",domain, cvData!!.android_uiData,data,elementName)
        operateDomainForEdit("Android_OS",domain, cvData!!.android_osData,data,elementName)
        operateDomainForEdit("Android_FS",domain, cvData!!.android_fileSystemData,data,elementName)


            val writer = FileWriter(path);
            var gson = Gson()
            var json = gson.toJson(cvData);

            Log.e(TAG, cvData.toString());



            writer.write(json);
            writer.flush();
            writer.close();
            parseJson(context);

            // for (i in javaUnused) {
            //     Log.d(TAG, i.toString())
            // }

            // Log.d(TAG, javaDataList.toString())



    }
fun operateDomainForEdit(requestedDomain:String,domain : String,list:ArrayList<LanguageData>, data:LanguageData,elementName: String)
{
    if (domain.equals(requestedDomain)) {
        operateEdit(elementName,list,data)
    }
}
    fun operateEdit(elementName : String, languageDataList : java.util.ArrayList<LanguageData>,data:LanguageData) {

        var foundElement  = HelperFunctions.findInList(languageDataList,elementName)
        languageDataList.remove(foundElement)
        languageDataList.add(data)
        }
    fun operateDomainForAdd(requestedDomain:String,domain:String,list:ArrayList<LanguageData>, data:LanguageData)
    {
        if (domain.equals(requestedDomain)) {
            operateAdd(data,list)
        }
    }
    fun operateAdd(data:LanguageData,list:ArrayList<LanguageData>)
    {
              list.add(data)
    }





}
