package com.ttms.serviceImpl;

import com.ttms.dao.EmployeeDAO;

import com.ttms.entity.Employee;
import com.ttms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hjh on 16-12-1.
 */
@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public void insertEmployee(Employee employee) {

        employeeDAO.insertEmployee(employee);

    }

    @Override
    public void deleteEmployee(int emp_id) {

        employeeDAO.deleteEmployee(emp_id);

    }

    @Override
    public void updateEmployee(Employee employee) {

        employeeDAO.updateEmployee(employee);

    }

    @Override
    public Employee selectEmployeeByEmp_id(int emp_id) {

        Employee employee = null;
        employee = employeeDAO.selectEmployeeByEmp_id(emp_id);
        return employee;
    }

    @Override
    public Employee selectEmployeeByEmp_no(String emp_no) {

        Employee employee = null;
        employee = employeeDAO.selectEmployeeByEmp_no(emp_no);
        return employee;
    }

    @Override
    public List<Employee> selectEmployeeByEmp_name(String emp_name) {

        List<Employee> list = null;
        list = employeeDAO.selectEmployeeByEmp_name(emp_name);
        return list;
    }

    @Override
    public Employee selectEmployeeByEmp_tel_num(String emp_tel_num) {

        Employee employee = null;
        employee = employeeDAO.selectEmployeeByEmp_tel_num(emp_tel_num);
        return employee;
    }

    @Override
    public List<Employee> selectEmployeeByEmp_addr(String emp_addr) {

        List<Employee> list = null;
        list = employeeDAO.selectEmployeeByEmp_addr(emp_addr);
        return list;
    }

    @Override
    public Employee selectEmployeeByEmp_email(String emp_email) {

        Employee employee = null;
        employee = employeeDAO.selectEmployeeByEmp_email(emp_email);
        return employee;
    }

    @Override
    public List<Employee> selectEmployeeByEmp_sex(String emp_sex) {

        List<Employee> list = null;
        list = employeeDAO.selectEmployeeByEmp_sex(emp_sex);
        return list;
    }

    @Override
    public List<Employee> selectEmployeeByEmp_birth(String emp_birth) {

        List<Employee> list = null;
        list = employeeDAO.selectEmployeeByEmp_birth(emp_birth);
        return list;
    }

    @Override
    public List<Employee> selectEmployeeByEmp_native(String emp_native) {

        List<Employee> list = null;
        list = employeeDAO.selectEmployeeByEmp_native(emp_native);
        return list;
    }

    @Override
    public List<Employee> selectEmployee() {

        List<Employee> list = null;
        list = employeeDAO.selectEmployee();
        return list;
    }

    @Override
    public String changeEmployee(String emp_id, String emp_name, String emp_sex, String emp_birth, String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr) {

        String errors = "更新失败！";
        int id = Integer.parseInt(emp_id);
        Employee employee1 = employeeDAO.selectEmployeeByEmp_id(id);
        String emp_no = employee1.getEmp_no();
        String pass = employee1.getEmp_pass();
        String name = employee1.getEmp_name();
        String sex = employee1.getEmp_sex();
        String phone = employee1.getEmp_tel_num();
        String addr = employee1.getEmp_addr();
        String email = employee1.getEmp_email();
        String birth = employee1.getEmp_birth();
        String natives = employee1.getEmp_native();
        String pic = employee1.getEmp_pic();

        Employee employee = new Employee();
        employee.setEmp_id(id);
        employee.setEmp_no(emp_no);
        employee.setType(0);
        employee.setEmp_pic(pic);

        if(emp_name == null || emp_name.trim().length() <= 0){
            employee.setEmp_name(name);
        }else{
            employee.setEmp_name(emp_name);
        }

        if(emp_pass == null || emp_pass.trim().length() <= 0){
            employee.setEmp_pass(pass);
        }else{
            employee.setEmp_pass(emp_pass);
        }

        if(emp_sex == null || emp_sex.trim().length() <= 0){
            employee.setEmp_sex(sex);
        }else{
            employee.setEmp_sex(emp_sex);
        }

        if(emp_birth == null || emp_birth.trim().length() <= 0){
            employee.setEmp_birth(birth);
        }else{
            employee.setEmp_birth(emp_birth);
        }

        if(emp_native == null || emp_native.trim().length() <= 0){
            employee.setEmp_native(natives);
        }else{
            employee.setEmp_native(emp_native);
        }

        if(emp_tel_num == null || emp_tel_num.trim().length() <= 0){
            employee.setEmp_tel_num(phone);
        }else{
            employee.setEmp_tel_num(emp_tel_num);
        }

        if(emp_email == null || emp_email.trim().length() <= 0){
            employee.setEmp_email(email);
        }else{
            employee.setEmp_email(emp_email);
        }


        if(emp_addr == null || emp_addr.trim().length() <= 0){
            employee.setEmp_addr(addr);
        }else{
            employee.setEmp_addr(emp_addr);
        }

        employeeDAO.updateEmployee(employee);
        errors = "更新成功！";

        return  errors;

    }

    @Override
    public String changeTopEmployee(String emp_id, String emp_name, String emp_sex, String emp_birth, String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr) {

        String errors = "更新失败！";
        int id = Integer.parseInt(emp_id);
        Employee employee1 = employeeDAO.selectEmployeeByEmp_id(id);
        String emp_no = employee1.getEmp_no();
        String pass = employee1.getEmp_pass();
        String name = employee1.getEmp_name();
        String sex = employee1.getEmp_sex();
        String phone = employee1.getEmp_tel_num();
        String addr = employee1.getEmp_addr();
        String email = employee1.getEmp_email();
        String birth = employee1.getEmp_birth();
        String natives = employee1.getEmp_native();
        String pic = employee1.getEmp_pic();

        Employee employee = new Employee();
        employee.setEmp_id(id);
        employee.setEmp_no(emp_no);
        employee.setType(1);
        employee.setEmp_pic(pic);

        if(emp_name == null || emp_name.trim().length() <= 0){
            employee.setEmp_name(name);
        }else{
            employee.setEmp_name(emp_name);
        }

        if(emp_pass == null || emp_pass.trim().length() <= 0){
            employee.setEmp_pass(pass);
        }else{
            employee.setEmp_pass(emp_pass);
        }

        if(emp_sex == null || emp_sex.trim().length() <= 0){
            employee.setEmp_sex(sex);
        }else{
            employee.setEmp_sex(emp_sex);
        }

        if(emp_birth == null || emp_birth.trim().length() <= 0){
            employee.setEmp_birth(birth);
        }else{
            employee.setEmp_birth(emp_birth);
        }

        if(emp_native == null || emp_native.trim().length() <= 0){
            employee.setEmp_native(natives);
        }else{
            employee.setEmp_native(emp_native);
        }

        if(emp_tel_num == null || emp_tel_num.trim().length() <= 0){
            employee.setEmp_tel_num(phone);
        }else{
            employee.setEmp_tel_num(emp_tel_num);
        }

        if(emp_email == null || emp_email.trim().length() <= 0){
            employee.setEmp_email(email);
        }else{
            employee.setEmp_email(emp_email);
        }


        if(emp_addr == null || emp_addr.trim().length() <= 0){
            employee.setEmp_addr(addr);
        }else{
            employee.setEmp_addr(emp_addr);
        }

        employeeDAO.updateEmployee(employee);
        errors = "更新成功！";

        return  errors;
    }




    @Override
    public String addEmployee(String emp_name, String emp_sex, String emp_birth, String emp_no, String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr) {

        String errors = "该用户名已被使用！";
        Employee employee = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee == null){

            Employee employee1 = new Employee();
            employee1.setEmp_name(emp_name);
            employee1.setEmp_sex(emp_sex);
            employee1.setEmp_birth(emp_birth);
            employee1.setEmp_no(emp_no);
            employee1.setEmp_pass(emp_pass);
            employee1.setType(0);
            employee1.setEmp_native(emp_native);
            employee1.setEmp_tel_num(emp_tel_num);
            employee1.setEmp_email(emp_email);
            employee1.setEmp_addr(emp_addr);
            employeeDAO.insertEmployee(employee1);
            errors = "添加用户成功！";
        }

        return errors;

    }

    @Override
    public String addTopEmployee(String emp_name, String emp_sex, String emp_birth, String emp_no, String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr) {

        String errors = "该用户名已被使用！";
        Employee employee = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee == null){

            Employee employee1 = new Employee();
            employee1.setEmp_name(emp_name);
            employee1.setEmp_sex(emp_sex);
            employee1.setEmp_birth(emp_birth);
            employee1.setEmp_no(emp_no);
            employee1.setEmp_pass(emp_pass);
            employee1.setType(1);
            employee1.setEmp_native(emp_native);
            employee1.setEmp_tel_num(emp_tel_num);
            employee1.setEmp_email(emp_email);
            employee1.setEmp_addr(emp_addr);
            employeeDAO.insertEmployee(employee1);
            errors = "添加用户成功！";
        }

        return errors;

    }

    @Override
    public List<Employee> selectCommonEmployee() {

        List<Employee> list = null;
        list = employeeDAO.selectCommonEmployee();
        return list;
    }

    @Override
    public List<Employee> selectTopEmployee() {

        List<Employee> list = null;
        list = employeeDAO.selectTopEmployee();
        return list;
    }
}
