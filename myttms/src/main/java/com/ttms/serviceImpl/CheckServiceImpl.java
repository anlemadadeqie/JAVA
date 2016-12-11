package com.ttms.serviceImpl;

import com.ttms.dao.EmployeeDAO;
import com.ttms.dao.UserDAO;
import com.ttms.entity.Employee;
import com.ttms.entity.User;
import com.ttms.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hjh on 16-12-1.
 */
@Service("CheckServiceImpl")
public class CheckServiceImpl implements CheckService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    EmployeeDAO employeeDAO;


    @Override
    public int checkLogin(String emp_no, String emp_pass) {
        int type = -1;
        User user = userDAO.selectUserByEmp_no(emp_no);
        if(user == null){

            return type;
        }
        String pass = user.getEmp_pass();
        if(pass.equals(emp_pass)){

            return user.getType();
        }
        return type;
    }

    @Override
    public int checkRegister(String emp_no, String emp_pass, String emp_email) {

        int result = -1;
        User user = null;
        Employee employee = null;
        employee = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee == null){
            Employee employee1 = new Employee();
            employee1.setEmp_no(emp_no);
            employee1.setEmp_email(emp_email);
            employeeDAO.insertEmployee(employee1);
            user = new User();
            user.setEmp_no(emp_no);
            user.setEmp_pass(emp_pass);
            user.setType(0);
            userDAO.insertUser(user);
            result = 0;

        }
        return result;
    }

    @Override
    public void changePass(String emp_no, String emp_pass) {

        User user = new User();
        user.setEmp_no(emp_no);
        user.setEmp_pass(emp_pass);
        user.setType(0);
        userDAO.updateUser(user);

    }
}
