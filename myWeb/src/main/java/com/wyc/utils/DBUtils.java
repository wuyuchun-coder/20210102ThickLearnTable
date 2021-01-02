package com.wyc.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.wyc.bean.Applicant;
import com.wyc.bean.ApplicantInfo;
import com.wyc.bean.VideoInfo;
import com.wyc.bean.remarkInfo;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.sql.*;
import java.util.*;

import static jdk.internal.net.http.common.Utils.close;

public class DBUtils {
    public static Connection getConnection() throws Exception {
        InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("config/db.properties");
        Properties properties=new Properties();
        properties.load(in);
        DataSource dataSource=new DruidDataSourceFactory().createDataSource(properties);
        return dataSource.getConnection();
    }
    public static void close(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(conn!=null)
            conn.close();
        if(preparedStatement!=null)
            preparedStatement.close();
        if(resultSet!=null)
            resultSet.close();
    }
    public static boolean save(String sql,Object...args) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        Integer count=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        if(args!=null&&args.length>0){
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
        }

        count=preparedStatement.executeUpdate();
        close(conn,preparedStatement,null);
        return count!=null&&count>0?true:false;
    }
    public static int selectUserNumById(String sql,Object...args) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer count=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        close(conn,preparedStatement,resultSet);
        return count;
    }

    public static <T>T getOneUser(Class<T> applicantClass, String sql, Object...args) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer count=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        T bean=null;
       for(int i=0;i<args.length;i++){
           preparedStatement.setObject(i+1,args[i]);
       }
        resultSet=preparedStatement.executeQuery();
        ResultSetMetaData rsd;
        rsd=resultSet.getMetaData();

        int column=rsd.getColumnCount();
        while(resultSet.next()){
            bean=applicantClass.newInstance();
            Map<String,Object>hashmap=new HashMap<>();
            for(int i=1;i<=column;i++){
                String columnName=rsd.getColumnLabel(i);
                Object columnvalue=resultSet.getObject(columnName);
                hashmap.put(columnName,columnvalue);
            }
            for(Map.Entry<String,Object>entry:hashmap.entrySet()){
                String name=entry.getKey();
                Object value=entry.getValue();
                BeanUtils.setProperty(bean,name,value);
            }
        }
        return bean;

    }

    public static boolean saveApplicantInfo(String sql, Object...args) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer count=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        if(args!=null&&args.length>0){
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
        }
        count=preparedStatement.executeUpdate();
        return count!=null&&count>0?true:false;
    }

    public static String selectShot(String sql, Object...args) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        String headshot=null;
        if(args!=null&&args.length>0){
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
        }
        resultSet=preparedStatement.executeQuery();
        ResultSetMetaData rsd;
        rsd=resultSet.getMetaData();
        while(resultSet.next()){
            headshot=(String) resultSet.getObject(1);
        }

        close(conn,preparedStatement,resultSet);
        return headshot;
    }
    public static List selectRemarkInfo(String sql, int videoid) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(1,videoid);
        resultSet=preparedStatement.executeQuery();
        ResultSetMetaData rsd;
        rsd=resultSet.getMetaData();
        List<remarkInfo>allRemarkInfo=new ArrayList<>();
        int num=1;
        while(resultSet.next()){
            String content=(String) resultSet.getObject(1);
            String time=(String)resultSet.getObject(2);
            String poster=(String)resultSet.getObject(3);
            int remarkvideoid=(int)resultSet.getObject(4);
            remarkInfo remarkInfo=new remarkInfo(content,time,poster,remarkvideoid);
            allRemarkInfo.add(remarkInfo);
        }
        return allRemarkInfo;
    }

    public static List<VideoInfo> selectVideoInfo(String sql) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        List<VideoInfo>videoInfo=new ArrayList<>();
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            int videoId=(int)resultSet.getObject(1);
            String videoName=(String)resultSet.getObject(2);
            String videoType=(String)resultSet.getObject(3);
            String videoAddress=(String)resultSet.getObject(4);
            String pageshow=(String)resultSet.getObject(5);
           Integer videoboard=(Integer)resultSet.getObject(6);
            VideoInfo videoInfo1=new VideoInfo(videoId,videoName,videoType,videoAddress,pageshow,videoboard);
            videoInfo.add(videoInfo1);;
        }
        return videoInfo;
    }

    public static ApplicantInfo selectApplicantInfo(String sql) throws Exception {
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        ApplicantInfo applicantInfo=null;
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            String applicantName=(String)resultSet.getObject(1);
            int applicantAge=(int)resultSet.getObject(2);
            String applicantAge1=String.valueOf(applicantAge);
            String applicantSex=(String)resultSet.getObject(3);
            String applicantBirthday=(String)resultSet.getObject(4);
            String applicantTelephone=(String)resultSet.getObject(5);
            String applicantEmail=(String)resultSet.getObject(6);
            String applicantHeadshot=(String) resultSet.getObject(7);
            applicantInfo=new ApplicantInfo(applicantEmail,applicantName,applicantAge1,applicantSex,applicantBirthday,applicantTelephone,applicantHeadshot);

        }
        return  applicantInfo;
    }

    public static boolean changePassword(String sql,String applicantEmail,String newpassword) throws Exception {
        Integer count=null;
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();

        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(1,newpassword);
        preparedStatement.setObject(2,applicantEmail);
       count= preparedStatement.executeUpdate();

       if(count>0)
           return true;
       else
       {
           return false;
       }
    }

    public static boolean updateApplicantInfo(String sql, ApplicantInfo applicantInfo) throws Exception {
        Connection conn=null;
        Integer count=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(1,applicantInfo.getName());
        preparedStatement.setObject(2,applicantInfo.getAge());
        preparedStatement.setObject(3,applicantInfo.getSex());
        preparedStatement.setObject(4,applicantInfo.getBirthday());
        preparedStatement.setObject(5,applicantInfo.getTelephone());
        preparedStatement.setObject(6,applicantInfo.getapplicantEmail());
        preparedStatement.setObject(7,applicantInfo.getHeadshot());
        preparedStatement.setObject(8,applicantInfo.getapplicantEmail());
        count= preparedStatement.executeUpdate();
        if(count>0)
            return true;
        else{
            return false;
        }
    }

    public static boolean updateApplicantPic(String sql, String applicantEmail, String fileName) throws Exception {
        Connection conn=null;
        Integer count=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(1,fileName);
        preparedStatement.setObject(2,applicantEmail);
        count= preparedStatement.executeUpdate();
        if(count>0)
            return true;
        else{
            return false;
        }
    }

    public static boolean changeVideoType(String sql, String videoName, String videoType) throws Exception {
        Connection conn=null;
        Integer count=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(2,videoName);
        preparedStatement.setObject(1,videoType);
        count= preparedStatement.executeUpdate();
        if(count>0)
            return true;
        else{
            return false;
        }
    }

    public static boolean setVideoName(String sql, String videoName,String videoType, String addvideoName,String videoPic) throws Exception {
        Connection conn=null;
        Integer count=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(1,videoName);
        preparedStatement.setObject(2,videoType);
        preparedStatement.setObject(3,addvideoName);
        preparedStatement.setObject(4,videoPic);
        count=preparedStatement.executeUpdate();
        if(count>0)
            return true;
        else{
            return false;
        }
    }

    public static boolean changeVideoBoard(String sql,int board,int videoId) throws Exception {
        Connection conn=null;
        Integer count=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        conn=DBUtils.getConnection();
        preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setObject(1,board);
        preparedStatement.setObject(2,videoId);
        count=preparedStatement.executeUpdate();
        if(count>0)
            return true;
        else{
            return false;
        }
    }
}
