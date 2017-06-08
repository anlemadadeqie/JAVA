package com.ttms.service;

import com.ttms.entity.Employee;

import java.util.List;

/**
 * Created by hjh on 16-12-1.
 */
public interface EmployeeService {

    public void insertEmployee(Employee employee);
    public void deleteEmployee(int emp_id);
    public void updateEmployee(Employee employee);

    public Employee selectEmployeeByEmp_id(int emp_id);
    public Employee selectEmployeeByEmp_no(String emp_no);
    public List<Employee> selectEmployeeByEmp_name(String emp_name);
    public Employee selectEmployeeByEmp_tel_num(String emp_tel_num);
    public List<Employee> selectEmployeeByEmp_addr(String emp_addr);
    public Employee selectEmployeeByEmp_email(String emp_email);
    public List<Employee> selectEmployeeByEmp_sex(String emp_sex);
    public List<Employee> selectEmployeeByEmp_birth(String emp_birth);
    public List<Employee> selectEmployeeByEmp_native(String emp_native);
    public List<Employee> selectEmployee();
    public String changeEmployee(String emp_id, String emp_name, String emp_sex, String emp_birth, String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr);
    public String changeTopEmployee(String emp_id, String emp_name, String emp_sex, String emp_birth, String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr);

    public String addEmployee(String emp_name, String emp_sex, String emp_birth, String emp_no,
                              String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr);
    public String addTopEmployee(String emp_name, String emp_sex, String emp_birth, String emp_no,
                                 String emp_pass, String emp_native, String emp_tel_num, String emp_email, String emp_addr);
    public List<Employee> selectCommonEmployee();
    public List<Employee> selectTopEmployee();
}
