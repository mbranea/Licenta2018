package com.example.madalinbranea.myapplication.JsonParsing;

import com.example.madalinbranea.myapplication.JsonParsing.LanguageData;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class HelperFunctions {

    public static  LanguageData JsonObjectToLanguageItem(JsonObject object)
    {
return new LanguageData(object.get("elementName").getAsString(),object.get("duration").getAsString(),object.get("appraisal").getAsString(),object.get("Comments").getAsString());

    }
    public static LanguageData findInList(ArrayList<LanguageData> list,String elementName)
    {

            for(LanguageData i : list)
            {
                if(i.getElementName().equals(elementName) )
                {
                    return i;
                }
            }
            return new LanguageData();

    }

}
