package com.ttms.dao;

import com.ttms.idao.IUser;
import com.ttms.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by hjh on 16-10-31.
 */
public class UserDAO implements IUser {
    public boolean insert(User user) {
        boolean result = false;
        if (user == null) {
            return result;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into user(emp_no,emp_pass,type) values(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.setString(2, user.getEmp_pass());
            pstmt.setInt(3, user.getType());

            pstmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    public boolean delete(User user) {
        boolean result = false;
        if (user == null) {
            return result;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from user where emp_no=? ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(null, pstmt, con);
            return result;
        }

    }

    public boolean update(User user) {
        boolean result = false;
        if (user == null) {
            return result;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "update user set emp_no=?, emp_pass=?, type=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.setString(2, user.getEmp_pass());
            pstmt.setInt(3, user.getType());

            pstmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    public User findUserByno(String emp_no) {

        if(emp_no == null){
            return null;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try{
            String sql = "select * from user where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, emp_no);

            rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User();
                user.setEmp_no(emp_no);
                user.setEmp_pass(rs.getString("emp_pass"));
                user.setType(rs.getInt("type"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.close(rs, pstmt, con);
            return user;
        }
    }

}


