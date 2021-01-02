package com.wyc.bean;

public class Applicant {
    private Integer applicantID;

    private String  applicantEmail;
    private String applicantPwd;

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    private int isAdmin;
    public Applicant( String applicantEmail, String applicantPwd) {

        this.applicantEmail = applicantEmail;
        this.applicantPwd = applicantPwd;
    }

   public Applicant(String applicantEmail, String applicantPwd,int isAdmin){
       this.applicantEmail = applicantEmail;
       this.applicantPwd = applicantPwd;
       this.isAdmin=isAdmin;
   }
    public Applicant(){

    }
    public Integer getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantPwd() {
        return applicantPwd;
    }

    public void setApplicantPwd(String applicantPwd) {
        this.applicantPwd = applicantPwd;
    }

}
