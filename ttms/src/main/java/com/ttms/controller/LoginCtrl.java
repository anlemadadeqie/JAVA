package com.ttms.controller;

import com.ttms.service.Logins;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by hjh on 16-10-27.
 */

public class LoginCtrl extends HttpServlet {

    private String USER_VIEW; //普通员工改密码 0
    private String EMPY_VIEW;   //管理员工管理页面 1
    private String ERROR_VIEW;  //报错页面

    public void init() throws ServletException{
        USER_VIEW = getInitParameter("User");
        EMPY_VIEW = getInitParameter("Empy");
        ERROR_VIEW = getInitParameter("Error");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String page = ERROR_VIEW;

        Logins loginer = new Logins();

        try{
            int result = loginer.checkLogin(name, password);
            if(result == 0){
                request.getSession().setAttribute("login", name);
                page = USER_VIEW;

            }else if(result == 1){
                request.getSession().setAttribute("login", name);
                page = EMPY_VIEW;
            }else{
                request.setAttribute("errors","名称或密码错误!");
            }
        }catch(Exception e){

            e.printStackTrace();

        }
        request.getRequestDispatcher(page).forward(request, response);

    }

}
