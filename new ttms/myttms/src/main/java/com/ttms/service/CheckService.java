package com.ttms.service;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by hjh on 16-12-1.
 */
public interface CheckService {

    public int checkLogin(String emp_no, String emp_pass);
    public int checkRegister(String emp_no, String emp_pass, String emp_email);
    public String changePass(HttpServletRequest request);
    public String updatePic(HttpServletRequest request);
}
