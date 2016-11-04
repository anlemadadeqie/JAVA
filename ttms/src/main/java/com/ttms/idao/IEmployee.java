package com.ttms.idao;

import com.ttms.model.Employee;

import java.util.ArrayList;

/**
 * Created by hjh on 16-10-30.
 */
/*定义对用户表的增删改查接口*/
public interface IEmployee {

    //增
    public boolean insert(Employee employee);

    //删
    public boolean delete(int employeeId);

    //改
    public boolean update(Employee employee);

    //查所有用户
    public ArrayList<Employee>  findEmployeeAll();

    //根据用户名查
    public ArrayList<Employee> findEmployeeByName(String employeeName);

    //根据编号查
    public Employee findEmployeeByNo(String employeeno);

    //根据用户id查
    public Employee findEmployeeById(int employeeId);

}
