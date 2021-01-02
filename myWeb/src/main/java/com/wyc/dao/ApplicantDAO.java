package com.wyc.dao;

import com.wyc.bean.Applicant;
import com.wyc.bean.ApplicantInfo;
import com.wyc.utils.DBUtils;

public class ApplicantDAO {
    //保存注册对象
    public boolean saveApplicant(Applicant applicant) throws Exception {
        String sql="insert into Applicant(APPLICANT_EMAIL,APPLICANT_PASSWORD)"
                +"values(?,?)";
        return   DBUtils.save(sql,applicant.getApplicantEmail(),applicant.getApplicantPwd());
    }
    //查看账号是否被注册
    public int selectIdNum(Applicant applicant) throws Exception {
        String sql="select count(*)from Applicant where APPLICANT_EMAIL='"+applicant.getApplicantEmail()+"'";
        return DBUtils.selectUserNumById(sql,null);
    }
    public Applicant selectUserByEmailAndPassword(String applicantEmail,String applicantPassword) throws Exception {
        String sql ="select APPLICANT_EMAIL applicantEmail,APPLICANT_PASSWORD applicantPwd,isAdmin isAdmin"
                +" from Applicant where APPLICANT_EMAIL=? and APPLICANT_PASSWORD=?";
        return DBUtils.getOneUser(Applicant.class,sql,applicantEmail,applicantPassword);
    }
    public boolean saveApplicantInfo(ApplicantInfo applicantInfo) throws Exception {
        String sql="insert into userInfo(APPLICANT_NAME,APPLICANT_AGE,APPLICANT_SEX,APPLICANT_BIRTHDAY,APPLICANT_TELEPHONE,APPLICANT_EMAIL,APPLICANT_HEADSHOT)"+"values(?,?,?,?,?,?,?)";
        return DBUtils.saveApplicantInfo(sql,applicantInfo.getName(),applicantInfo.getAge(),applicantInfo.getSex(),applicantInfo.getBirthday(),applicantInfo.getTelephone(),applicantInfo.getapplicantEmail(),applicantInfo.getHeadshot());
    }

    public String selectHeadShot(Applicant applicant) throws Exception {
        String sql="select APPLICANT_HEADSHOT from userinfo where APPLICANT_EMAIL =?";
        return  DBUtils.selectShot(sql,applicant.getApplicantEmail());
    }
    public ApplicantInfo selectApplicantInfo(String ApplicantEmail) throws Exception {
        String sql="select APPLICANT_NAME,APPLICANT_AGE,APPLICANT_SEX,APPLICANT_BIRTHDAY,APPLICANT_TELEPHONE,APPLICANT_EMAIL,APPLICANT_HEADSHOT from userinfo where APPLICANT_EMAIL="+"'"+ApplicantEmail+"'";
        return DBUtils.selectApplicantInfo(sql);
    }
    public boolean changeAppllicantPassword(String applicantEmail,String newpassword) throws Exception {
        String sql="update applicant set APPLICANT_PASSWORD=? where APPLICANT_EMAIL=?";
        return DBUtils.changePassword(sql,applicantEmail,newpassword);
    }
    public boolean updateApplicantInfo(ApplicantInfo applicantInfo) throws Exception {
        String sql="update userinfo set APPLICANT_NAME=?,APPLICANT_AGE=?,APPLICANT_SEX=?,APPLICANT_BIRTHDAY=?,APPLICANT_TELEPHONE=?,APPLICANT_EMAIL=?,APPLICANT_HEADSHOT=? where APPLICANT_EMAIL=?";
        return DBUtils.updateApplicantInfo(sql,applicantInfo);
    }

    public boolean changeAppicantPic(String applicantEmail, String fileName) throws Exception {
        String sql="update userinfo set APPLICANT_HEADSHOT=? where APPLICANT_EMAIL=?";
        return DBUtils.updateApplicantPic(sql,applicantEmail,fileName);
    }
}
