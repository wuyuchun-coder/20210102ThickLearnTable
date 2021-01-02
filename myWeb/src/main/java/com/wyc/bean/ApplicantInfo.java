package com.wyc.bean;

public class ApplicantInfo {
    String applicantEmail;
    String name;
    String age;
    String sex;
    String birthday;

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    String headshot;
    public ApplicantInfo(String applicantEmail, String name, String age, String sex, String birthday, String telephone,String headshot) {
        this.applicantEmail = applicantEmail;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.telephone = telephone;
        this.headshot=headshot;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    String telephone;
    public String getapplicantEmail() {
        return applicantEmail;
    }

    public void setapplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public ApplicantInfo(){

    }
    public ApplicantInfo(String applicantEmail, String name, String age, String sex, String birthday) {
        this.applicantEmail = applicantEmail;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }


}
