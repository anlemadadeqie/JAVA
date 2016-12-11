package com.ttms.controller;

import com.ttms.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hjh on 16-11-30.
 */
@Controller("UserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    CheckService checkService;



    @RequestMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request) {

        String emp_no = request.getParameter("username");
        String emp_pass = request.getParameter("password");

        String desc = "名称或密码错误";
        String page = "login";

        request.getSession().setAttribute("a", null);
        request.getSession().setAttribute("b", null);

        int result = checkService.checkLogin(emp_no, emp_pass);
        if (result == 0) {

            request.getSession().setAttribute("login", "yes");
            request.getSession().setAttribute("a", "ok");
            request.getSession().setAttribute("names", emp_no);
            page = "list";
            desc = emp_no + "登录";
        }
        if (result == 1) {

            request.getSession().setAttribute("login", "yes");
            request.getSession().setAttribute("b", "ok");
            request.getSession().setAttribute("names", emp_no);
            page = "list";
            desc = emp_no + "登录";

        }
        request.setAttribute("desc", desc);
        return new ModelAndView(page);
    }


    @RequestMapping("/register")
    public ModelAndView registerPage(HttpServletRequest request){

        String emp_no = request.getParameter("name");
        String emp_pass = request.getParameter("password");
        String emp_email = request.getParameter("mail");
        int result = checkService.checkRegister(emp_no, emp_pass, emp_email);
        if(result == 0){

            request.setAttribute("errors","注册成功,欢迎登录");
        }
        else{
            request.setAttribute("errors","该用户名已被注册!");
        }

        return new ModelAndView("login");
    }


    @RequestMapping("/")
     public ModelAndView lostPasswordPage(HttpServletRequest request){
         return null;
     }


    @RequestMapping("/updatepass")
    public ModelAndView updatePasswordPage(HttpServletRequest request){

        String emp_no = (String)request.getSession().getAttribute("names");
        String emp_pass = request.getParameter("pa1");
        checkService.changePass(emp_no, emp_pass);
        return new ModelAndView("login");
    }

}
