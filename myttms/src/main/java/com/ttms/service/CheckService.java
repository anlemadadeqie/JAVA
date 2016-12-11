package com.ttms.service;

import com.ttms.entity.User;

/**
 * Created by hjh on 16-12-1.
 */
public interface CheckService {

    public int checkLogin(String emp_no, String emp_pass);
    public int checkRegister(String emp_no, String emp_pass, String emp_email);
    public void changePass(String emp_no, String emp_pass);
}
