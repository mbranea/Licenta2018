package src.Converter;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.font.FontSelector;
import com.sun.javafx.font.FontFactory;
import src.JsonClasses.Personal;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PDFCreator {

    final static PDFCreator instance = new PDFCreator();

    private PDFCreator(){};

    public static PDFCreator getInstance()
    {
       return instance;
    }

    Personal personalData = new Personal();

    public void setPersonalData(Personal personalData) {
        this.personalData = personalData;
    }






    public void createPDF() throws FileNotFoundException {
        String dest = "example.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        Document document = new Document(pdfDoc);
        addPersonalInfo(document);
        addSkills(document);

        document.close();
        pdfDoc.close();


    }

    private void addPersonalInfo(Document document)
    {
        document.add(new Paragraph("Last Name: " + personalData.getLastName()));
        document.add(new Paragraph("First Name: " + personalData.getFirstName()));
        document.add(new Paragraph("Age: " + personalData.getAge()));
        document.add(new Paragraph("LastSchool: " + personalData.getLastSchool()));
        document.add(new Paragraph("E-Mail: " + personalData.getEMail()));

    }
    private void addSkills(Document document){
        addLanguageData(document,JSONParser.javaDataList,"Java");
        addLanguageData(document,JSONParser.cDataList,"CPlusPlus");
        addLanguageData(document,JSONParser.javaScriptList,"JavaScript");
        addLanguageData(document,JSONParser.htmlDataList,"HTML");
        addLanguageData(document,JSONParser.cssDataList,"CSS");
        addLanguageData(document,JSONParser.premadeDataList,"Premade Tools");
        addLanguageData(document,JSONParser.pythonDataList,"Python");
        addLanguageData(document,JSONParser.csharpDataList,"C#");
        addLanguageData(document,JSONParser.haskellDataList,"Haskell");
        addLanguageData(document,JSONParser.perlDataList,"Perl");
        addLanguageData(document,JSONParser.erlangDataList,"Erlang");
        addLanguageData(document,JSONParser.lispDataList,"Lisp");
        addLanguageData(document,JSONParser.mavenDataList,"Maven");
        addLanguageData(document,JSONParser.antDataList,"Ant");
        addLanguageData(document,JSONParser.android_uiDataList,"Android UI Design");
        addLanguageData(document,JSONParser.android_osDataList,"Android OS");
        addLanguageData(document,JSONParser.android_fileSystemDataList,"Android File System");


    }
    private void addLanguageData(Document document,List<LanguageItem> list,String domain)
    {
        if(list.size()>0){

Paragraph p = new Paragraph(domain);


            document.add(p);

        for(LanguageItem item : list) {
            document.add(new Paragraph("Element Name: " + item.getElementName() + "\n" + "Appraisal: " + item.getAppraisal() +
                    "\n" + "Duration: " + item.getDuration() + "\n" + "Comments: " + item.getComments()));
        }
        }
    }

}
