package com.ttms.serviceImpl;

import com.ttms.dao.EmployeeDAO;
import com.ttms.dao.UserDAO;
import com.ttms.entity.Employee;
import com.ttms.entity.User;
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
    @Autowired
    UserDAO userDAO;

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
    public void changeCommonEmployee(String emp_name, String emp_sex, String emp_birth, String emp_no, String emp_native, String emp_tel_num, String emp_email, String emp_addr) {
        Employee employee = new Employee();
        employee.setEmp_name(emp_name);
        employee.setEmp_sex(emp_sex);
        employee.setEmp_birth(emp_birth);
        employee.setEmp_no(emp_no);
        employee.setEmp_native(emp_native);
        employee.setEmp_tel_num(emp_tel_num);
        employee.setEmp_email(emp_email);
        employee.setEmp_addr(emp_addr);
        Employee employee1 = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee1 == null){
            employeeDAO.insertEmployee(employee);
        }else{
            employeeDAO.updateEmployee(employee);
        }

    }

    @Override
    public int changeEmployee(String emp_name, String emp_sex, String emp_birth, String emp_no, String emp_native, String emp_tel_num, String emp_email, String emp_addr) {

        int result = 0;

        Employee employee = new Employee();
        employee.setEmp_name(emp_name);
        employee.setEmp_sex(emp_sex);
        employee.setEmp_birth(emp_birth);
        employee.setEmp_no(emp_no);
        employee.setEmp_native(emp_native);
        employee.setEmp_tel_num(emp_tel_num);
        employee.setEmp_email(emp_email);
        employee.setEmp_addr(emp_addr);
        Employee employee1 = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee1 == null){
            employeeDAO.insertEmployee(employee);
        }else{
            employeeDAO.updateEmployee(employee);
        }
        User user = null;
        user = userDAO.selectUserByEmp_no(emp_no);
        if(user != null) {
            user.setType(1);
            userDAO.updateUser(user);
            result = 1;
        }

        return result;
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
