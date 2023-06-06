package com.example.tarea2;

import android.os.Parcel;
import android.os.Parcelable;

public class Questionary implements Parcelable {
    private String name;
    private String phone;
    private String hobby;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }


    public Questionary(String n, String t, String h, String q1, String q2, String q3, String q4, String q5){
        super();
        this.name = n;
        this.phone = t;
        this.hobby = h;
        this.question1 = q1;
        this.question2 = q2;
        this.question3 = q3;
        this.question4 = q4;
        this.question5 = q5;
    }

    public Questionary(Parcel source){
        this.name = source.readString();
        this.phone = source.readString();
        this.hobby = source.readString();
        this.question1 = source.readString();
        this.question2 = source.readString();
        this.question3 = source.readString();
        this.question4 = source.readString();
        this.question5 = source.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel d, int flags){
        d.writeString(name);
        d.writeString(phone);
        d.writeString(hobby);
        d.writeString(question1);
        d.writeString(question2);
        d.writeString(question3);
        d.writeString(question4);
        d.writeString(question5);
    }

    public static final Parcelable.Creator<Questionary> CREATOR = new Parcelable.Creator<Questionary>(){
        @Override
        public Questionary createFromParcel (Parcel source){
            return new Questionary(source);
        }

        @Override
        public Questionary[] newArray(int size){
            return new Questionary[size];
        }
    };
}
