package com.ttms.dao;

import com.ttms.idao.IEmployee;
import com.ttms.model.Employee;
import com.ttms.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Created by hjh on 16-10-30.
 */
public class EmployeeDAO implements IEmployee {

    //插入用户信息
    public boolean insert(Employee employee) {
        boolean result = false;
        if(employee == null){
            return result;
        }
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try{
            String sql = "insert into Employee(emp_no, emp_name. emp_tel_num, emp_addr, emp_email) values(?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employee.getEmp_no());
            pstmt.setString(2, employee.getEmp_name());
            pstmt.setString(3, employee.getEmp_tel_num());
            pstmt.setString(4, employee.getEmp_addr());
            pstmt.setString(5, employee.getEmp_email());
            pstmt.setInt(6, employee.getEmp_id());

            pstmt.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.close(null, pstmt, con);
            return  result;
        }
    }

    public boolean delete(int employeeId) {
        boolean result = false;
        if(employeeId == 0){
            return  result;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try{

            String sql = "delete from employee where emp_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            ConnectionManager.close(null, pstmt, con);
            return  result;
        }
    }

    public boolean update(Employee employee) {
        boolean result = false;
        if(employee == null){
            return  result;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try{

            String sql = "update employee set emp_no=?, emp_name=?, emp_tel_num=?, emp_addr=?, emp_email=? where emp_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employee.getEmp_no());
            pstmt.setString(2, employee.getEmp_name());
            pstmt.setString(3, employee.getEmp_tel_num());
            pstmt.setString(4, employee.getEmp_addr());
            pstmt.setString(5, employee.getEmp_email());
            pstmt.setInt(6, employee.getEmp_id());

            pstmt.executeUpdate();
            result = true;

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.close(null, pstmt, con);
            return result;
        }


    }

    public ArrayList<Employee> findEmployeeAll() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        Employee info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt = con.prepareStatement("select * from employee");
            rs = pstmt.executeQuery();
            while(rs.next()){
                info = new Employee();
                info.setEmp_addr(rs.getString("emp_adder"));
                info.setEmp_email(rs.getString("emp_email"));
                info.setEmp_id(rs.getInt("emp_id"));
                info.setEmp_name(rs.getString("emp_name"));
                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_tel_num(rs.getString("emp_tel_num"));

                list.add(info);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.close(rs, pstmt, con);
            return list;
        }
    }

    public ArrayList<Employee> findEmployeeByName(String employeeName) {
        if(employeeName == null || employeeName.equals(""))
            return null;

        ArrayList<Employee> list = new ArrayList<Employee>();
        Employee info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据:模糊查询
            pstmt = con.prepareStatement("select * from employee where emp_name like ?");
            pstmt.setString(1, "%" + employeeName + "%");// 拼接模糊查询串
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                info = new Employee();
                info.setEmp_id(rs.getInt("emp_id"));
                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_name(rs.getString("emp_name"));
                info.setEmp_tel_num(rs.getString("emp_tel_num"));
                info.setEmp_addr(rs.getString("emp_addr"));
                info.setEmp_email(rs.getString("emp_email"));
                list.add(info);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return list;
        }
    }

    public Employee findEmployeeByNo(String employeeno){
        if(employeeno == null){
            return null;
        }

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee emloyee = null;

        try{
            String sql = "select from employee where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employeeno);

            rs = pstmt.executeQuery();
            if(rs.next()){
                emloyee = new Employee();
                emloyee.setEmp_id(rs.getInt("id"));
                emloyee.setEmp_no(employeeno);
                emloyee.setEmp_name(rs.getString("emp_name"));
                emloyee.setEmp_tel_num(rs.getString("emp_tel_num"));
                emloyee.setEmp_addr(rs.getString("emp_addr"));
                emloyee.setEmp_email(rs.getString("emp_email"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.close(rs, pstmt, con);
            return emloyee;
        }
    }

    public Employee findEmployeeById(int employeeId) {

        Employee info = null;
        if(employeeId == 0)
            return info;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("select * from employee where emp_id=?");
            pstmt.setInt(1, employeeId);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                // 如果有值的话再实例化
                info = new Employee();
                info.setEmp_id(employeeId);
                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_name(rs.getString("emp_name"));
                info.setEmp_tel_num(rs.getString("emp_tel_num"));
                info.setEmp_addr(rs.getString("emp_addr"));
                info.setEmp_email(rs.getString("emp_email"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return info;
        }
    }
}
