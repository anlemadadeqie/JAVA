package com.ttms.controller;

import com.ttms.entity.Employee;
import com.ttms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hjh on 16-12-4.
 */
@Controller("EmployeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/changecommonemp")
    public ModelAndView addCommonEmployeePage(HttpServletRequest request){

        String emp_name = request.getParameter("name");
        String emp_sex = request.getParameter("sex");
        String emp_birth = request.getParameter("birth");
        String emp_no = request.getParameter("loginname");
        String emp_native = request.getParameter("native");
        String emp_tel_num = request.getParameter("tel");
        String emp_email = request.getParameter("mail");
        String emp_addr = request.getParameter("address");

        employeeService.changeCommonEmployee(emp_name, emp_sex, emp_birth, emp_no, emp_native, emp_tel_num, emp_email, emp_addr);
        request.setAttribute("errors","用户资料成功更新！");

        return new ModelAndView("/manager/rsxz/AddEmployee");
    }

    @RequestMapping("/changeemp")
    public ModelAndView addEmployeePage(HttpServletRequest request){


        String emp_name = request.getParameter("username");
        String emp_sex = request.getParameter("sexs");
        String emp_birth = request.getParameter("births");
        String emp_no = request.getParameter("loginnames");
        String emp_native = request.getParameter("natives");
        String emp_tel_num = request.getParameter("tels");
        String emp_email = request.getParameter("mails");
        String emp_addr = request.getParameter("addresss");
        System.out.println(emp_name);
        System.out.println(emp_sex);
        System.out.println(emp_birth);
        System.out.println(emp_no);
        System.out.println(emp_addr);

       int result = employeeService.changeEmployee(emp_name, emp_sex, emp_birth, emp_no, emp_native, emp_tel_num, emp_email, emp_addr);
        if(result == 1) {
            request.setAttribute("errors", "用户资料成功更新！");
        }else{
            request.setAttribute("errors","如要添加管理员，请先注册一个账号！");
        }
            return new ModelAndView("/manager/rsxz/AddTopEmployee");

    }

    @RequestMapping("/showcommonemp")
    public ModelAndView showCommonEmployeePage(HttpServletRequest request){

        List<Employee> list = null;
        list = employeeService.selectCommonEmployee();
        request.setAttribute("list", list);

        return new ModelAndView("/manager/rsxz/Employee") ;
    }

    @RequestMapping("/showemp")
    public ModelAndView showEmployeePage(HttpServletRequest request){

        List<Employee> list = null;
        list = employeeService.selectTopEmployee();
        request.setAttribute("list", list);

        return new ModelAndView("/manager/rsxz/TopEmployee");
    }

    @RequestMapping("/delcommonemp")
    public ModelAndView deleteCommonEmployeePage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        for(int i= 0; i < checkbox.length; i++){
            String id = checkbox[i];
            int emp_id = Integer.parseInt(id);
            employeeService.deleteEmployee(emp_id);
        }

        return showCommonEmployeePage(request);
    }

    @RequestMapping("/delemp")
    public ModelAndView deleteEmployeePage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        if(checkbox != null) {
            for (int i = 0; i < checkbox.length; i++) {
                String id = checkbox[i];
                int emp_id = Integer.parseInt(id);
                employeeService.deleteEmployee(emp_id);
            }
        }

        return showEmployeePage(request);
    }
}
