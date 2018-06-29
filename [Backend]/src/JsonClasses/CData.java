package src.JsonClasses;

import com.google.gson.annotations.Expose;

public class CData extends LanguageData {
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

    public CData(String elementName, String appraisal, String duration, String comments) {
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

    @Expose
    String elementName;

    @Override
    public String toString() {
        return "JavaData{" +
                "elementName='" + elementName + '\'' +
                ", appraisal='" + appraisal + '\'' +
                ", duration='" + duration + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
    @Expose
    String appraisal;
    @Expose
    String duration     ;
    @Expose
    String  comments;
}
