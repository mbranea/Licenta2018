package com.example.madalinbranea.myapplication.JsonParsing

import com.google.gson.JsonObject

open class LanguageData()
{
    var elementName: String? = null
    var duration: String? = null
    var appraisal: String? = null
    var Comments: String? = null

    constructor(elementName: String?, duration: String?, appraisal: String?,  Comments:  String?) : this() {
        this.elementName = elementName
        this.duration = duration
        this.appraisal = appraisal
        this.Comments = Comments
    }

    override fun toString(): String {
        return "LanguageData(elementName=$elementName, duration=$duration, appraisal=$appraisal, Comments=$Comments)"
    }
}
