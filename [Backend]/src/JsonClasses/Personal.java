package src.JsonClasses;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

public class Personal {
@Expose
    String LastName;

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "LastName='" + LastName + '\'' +
                ", EMail='" + EMail + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", age='" + age + '\'' +
                ", LastSchool='" + LastSchool + '\'' +
                '}';
    }

    public Personal(String lastName, String EMail, String firstName, String age, String lastSchool) {
        LastName = lastName;
        this.EMail = EMail;
        FirstName = firstName;
        this.age = age;
        LastSchool = lastSchool;
    }

    @Expose

String EMail;
public Personal(){}
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastSchool() {
        return LastSchool;
    }

    public void setLastSchool(String lastSchool) {
        LastSchool = lastSchool;
    }

    public Personal(String lastName, String firstName, String age, String lastSchool) {
        LastName = lastName;
        FirstName = firstName;
        age = age;
        LastSchool = lastSchool;
    }

    public Personal JSONToJavaPersonal(JsonObject object)
    {
        this.LastName = object.get("LastName").getAsString();
        this.FirstName = object.get("FirstName").getAsString();
        this.age = object.get("Age").getAsString();
        this.LastSchool = object.get("LastSchool").getAsString();
        this.EMail = object.get("EMail").getAsString();
        return this;
    }

    @Expose
    String FirstName;
    @Expose
    String age;
    @Expose
    String LastSchool;

}
