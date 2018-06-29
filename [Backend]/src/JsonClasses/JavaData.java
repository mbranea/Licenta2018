package src.JsonClasses;

import com.google.gson.annotations.Expose;

public class JavaData extends LanguageData {

    @Expose
    String appraisal;
    @Expose
    String duration     ;
    @Expose
    String elementName;
    @Expose
    String  comments;
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public void setAppraisal(String appraisal) {
        this.appraisal = appraisal;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public JavaData(String elementName, String appraisal, String duration, String comments) {
        this.elementName = elementName;
        this.appraisal = appraisal;
        this.duration = duration;
        this.comments = comments;
    }

    public String getElementName() {
        return elementName;
    }

    public String getAppraisal() {
        return appraisal;
    }

    public String getDuration() {
        return duration;
    }

    public String getComments() {
        return comments;
    }


    @Override
    public String toString() {
        return "JavaData{" +
                "elementName='" + elementName + '\'' +
                ", appraisal='" + appraisal + '\'' +
                ", duration='" + duration + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

}
