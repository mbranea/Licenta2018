package src.Converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;
import src.JsonClasses.JavaData;
import src.JsonClasses.Personal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONParser {
public static String eMail;
    public static ArrayList javaDataList = new ArrayList<LanguageItem>();
    public static ArrayList cDataList = new ArrayList<LanguageItem>();
    public static ArrayList javaScriptList = new ArrayList<LanguageItem>();
    public static ArrayList htmlDataList = new ArrayList<LanguageItem>();
    public static ArrayList cssDataList = new ArrayList<LanguageItem>();
    public static ArrayList premadeDataList = new ArrayList<LanguageItem>();
    public static ArrayList pythonDataList = new ArrayList<LanguageItem>();
    public static ArrayList csharpDataList = new ArrayList<LanguageItem>();
    public static ArrayList haskellDataList = new ArrayList<LanguageItem>();
    public static ArrayList perlDataList = new ArrayList<LanguageItem>();
    public static ArrayList erlangDataList = new ArrayList<LanguageItem>();
    public static ArrayList lispDataList = new ArrayList<LanguageItem>();
    public static ArrayList mavenDataList = new ArrayList<LanguageItem>();
    public static ArrayList gradleDataList = new ArrayList<LanguageItem>();
    public static ArrayList antDataList = new ArrayList<LanguageItem>();
    public static ArrayList android_uiDataList = new ArrayList<LanguageItem>();
    public static ArrayList android_osDataList = new ArrayList<LanguageItem>();
    public static ArrayList android_fileSystemDataList = new ArrayList<LanguageItem>();


    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    static JsonReader reader;









public static  void prints() throws IOException {


    reader = new JsonReader(new FileReader("Example - Copy.json"));

    JsonObject reviews = new Gson().fromJson(reader, JsonObject.class);

    JsonArray javaDataJsonArray = reviews.getAsJsonArray("JavaData");

  //  ArrayList<JavaData> JavaDataArray = ConversionHelper.jsonArrayToJavaArray(javaDataJsonArray);
    System.out.println(reviews.getAsJsonArray("JavaData"));

    List<Object> JavaDataArray = ConversionHelper.jsonArrayToJavaArray(javaDataJsonArray);



}



    public static  void parseJsonWithString(String inputString) throws IOException {

        FileUtils.writeStringToFile(new File("jsonFile.txt"), inputString);

    reader = new JsonReader(new FileReader("jsonFile.txt"));

        JsonObject body = new Gson().fromJson(reader, JsonObject.class);
        JsonObject personalData = body.getAsJsonObject("Personal");
        JsonArray javaDataArray = body.getAsJsonArray("JavaData");
        JsonArray cDataArray = body.getAsJsonArray("CData");
        JsonArray javaScriptArray = body.getAsJsonArray("jScriptData");
        JsonArray htmlDataArray = body.getAsJsonArray("htmlData");
        JsonArray cssArray = body.getAsJsonArray("cssData");
        JsonArray premadeDataArray = body.getAsJsonArray("premadeData");
        JsonArray pythonDataArray = body.getAsJsonArray("pythonData");
        JsonArray csharpDataArray = body.getAsJsonArray("csharpData");
        JsonArray haskellDataArray = body.getAsJsonArray("haskellData");
        JsonArray perlDataArray = body.getAsJsonArray("perlData");
        JsonArray erlangDataArray = body.getAsJsonArray("erlangData");
        JsonArray lispDataArray = body.getAsJsonArray("lispData");
        JsonArray mavenDataArray = body.getAsJsonArray("mavenData");
        JsonArray gradleDataArray = body.getAsJsonArray("gradleData");
        JsonArray antDataArray = body.getAsJsonArray("antData");
        JsonArray android_uiData = body.getAsJsonArray("android_uiData");
        JsonArray android_osData = body.getAsJsonArray("android_osData");
        JsonArray android_fileSystemData = body.getAsJsonArray("android_fileSystemData");
         javaDataList = ConversionHelper.jsonArrayToLanguageItemList(javaDataArray);
         cDataList = ConversionHelper.jsonArrayToLanguageItemList(cDataArray);
         javaScriptList = ConversionHelper.jsonArrayToLanguageItemList(javaScriptArray);
        htmlDataList = ConversionHelper.jsonArrayToLanguageItemList(htmlDataArray);
         cssDataList = ConversionHelper.jsonArrayToLanguageItemList(cssArray);
         premadeDataList = ConversionHelper.jsonArrayToLanguageItemList(premadeDataArray);
        pythonDataList = ConversionHelper.jsonArrayToLanguageItemList(pythonDataArray);
         csharpDataList = ConversionHelper.jsonArrayToLanguageItemList(csharpDataArray);
         haskellDataList = ConversionHelper.jsonArrayToLanguageItemList(haskellDataArray);
         perlDataList = ConversionHelper.jsonArrayToLanguageItemList(perlDataArray);
        erlangDataList = ConversionHelper.jsonArrayToLanguageItemList(erlangDataArray);
        lispDataList = ConversionHelper.jsonArrayToLanguageItemList(lispDataArray);
         mavenDataList = ConversionHelper.jsonArrayToLanguageItemList(mavenDataArray);
         gradleDataList = ConversionHelper.jsonArrayToLanguageItemList(gradleDataArray);
         antDataList = ConversionHelper.jsonArrayToLanguageItemList(antDataArray);
         android_uiDataList = ConversionHelper.jsonArrayToLanguageItemList(android_uiData);
         android_osDataList = ConversionHelper.jsonArrayToLanguageItemList(android_osData);
         android_fileSystemDataList = ConversionHelper.jsonArrayToLanguageItemList(android_fileSystemData);

        //PDFCreator.getInstance().setJavaLanguageData(javaDataList);

eMail = personalData.getAsJsonPrimitive("EMail").getAsString();
        PDFCreator.getInstance().setPersonalData(new Personal().JSONToJavaPersonal(personalData));
        PDFCreator.getInstance().createPDF();
    }






}


