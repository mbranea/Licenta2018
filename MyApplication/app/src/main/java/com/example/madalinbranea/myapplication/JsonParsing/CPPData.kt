package com.example.madalinbranea.myapplication.JsonParsing
class CPPData {
    var elementName: String? = null
    var duration: String? = null
    var appraisal: String? = null
    var Comments: String? = null
    constructor() : super() {}
    constructor(elementName: String, duration: String, appraisal: String,  Comments:  String) : super() {
        this.elementName = elementName
        this.duration = duration
        this.appraisal = appraisal
        this.Comments = Comments
    }
}