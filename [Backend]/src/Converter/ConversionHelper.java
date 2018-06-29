package src.Converter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import src.JsonClasses.LanguageData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionHelper {

    static ArrayList<Object> jsonArrayToJavaArray(JsonArray jsonArray) {
        ArrayList<Object> list = new ArrayList<Object>();
        if (jsonArray != null) {
            int len = jsonArray.size();
            for (int i = 0; i < len; i++) {
                list.add(jsonArray.get(i).toString());
            }
        }
        System.out.println(list);
        return list;
    }


    static ArrayList<LanguageItem> jsonArrayToLanguageItemList(JsonArray jsoncargo) {
        ArrayList<LanguageItem> list  = new ArrayList<LanguageItem>();
        for (int i = 0; i < jsoncargo.size(); i++) {

           JsonObject object =  jsoncargo.get(i).getAsJsonObject();
            LanguageItem item = new LanguageItem();
           item.setElementName(object.get("elementName").getAsString());
            item.setAppraisal(object.get("appraisal").getAsString());
            item.setDuration(object.get("duration").getAsString());
            item.setComments(object.get("Comments").getAsString());
            list.add(item);
        }
        return list;
    }


}
