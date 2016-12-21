package com.ttms.controller;

import com.ttms.entity.Employee;
import com.ttms.service.CheckService;
import com.ttms.service.EmployeeService;
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
    @Autowired
    EmployeeService employeeService;



    @RequestMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request) {

        String emp_no = request.getParameter("username");
        String emp_pass = request.getParameter("password");

        String page = "login";

        request.getSession().setAttribute("a", null);
        request.getSession().setAttribute("b", null);

        int result = checkService.checkLogin(emp_no, emp_pass);
        if (result == 0) {

            request.getSession().setAttribute("login", "yes");
            request.getSession().setAttribute("a", "ok");
            request.getSession().setAttribute("names", emp_no);
            page = "/ordinary/ChangePass";
        } else if (result == 1) {

            request.getSession().setAttribute("login", "yes");
            request.getSession().setAttribute("b", "ok");
            request.getSession().setAttribute("names", emp_no);
            Employee employee = employeeService.selectEmployeeByEmp_no(emp_no);
            request.setAttribute("employee", employee);
            page = "/manager/index";

        }else{

            page = "login";
            request.setAttribute("errors", "名称或密码错误！");
        }

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

        String errors = checkService.changePass(request);
        request.setAttribute("errors", errors);
        return new ModelAndView("login");
    }

    @RequestMapping("/updatepic")
    public ModelAndView updatePicPage(HttpServletRequest request){

        String errors = checkService.updatePic(request);
        String emp_no = (String)request.getSession().getAttribute("names");
        Employee employee = employeeService.selectEmployeeByEmp_no(emp_no);
        request.setAttribute("employee", employee);
        return new ModelAndView("/manager/index");
    }



    @RequestMapping("/quit")
    public ModelAndView quitPage(HttpServletRequest request){

        request.getSession().invalidate();
        return new ModelAndView("login");
    }

}
