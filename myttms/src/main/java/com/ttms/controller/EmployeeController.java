package com.ttms.controller;

import com.ttms.entity.Employee;
import com.ttms.service.EmployeeService;
import com.ttms.service.PageService;
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
    @Autowired
    PageService pageService;

    @RequestMapping("/changeemp")
    public ModelAndView changeEmployeePage(HttpServletRequest request){


        String emp_id = request.getParameter("id");
        String emp_name = request.getParameter("truename");
        String emp_sex = request.getParameter("sex");
        String emp_birth = request.getParameter("birth");
        String emp_pass = request.getParameter("password");
        String emp_native = request.getParameter("native");
        String emp_tel_num = request.getParameter("tel");
        String emp_email = request.getParameter("mail");
        String emp_addr = request.getParameter("address");
        String errors = employeeService.changeEmployee(emp_id, emp_name, emp_sex, emp_birth, emp_pass, emp_native, emp_tel_num, emp_email, emp_addr);

        return showEmployeePage(request);
    }

    @RequestMapping("/addemp")
    public ModelAndView addEmployeePage(HttpServletRequest request){

        String emp_name = request.getParameter("truename");
        System.out.println("aaa"+emp_name);
        String emp_sex = request.getParameter("sex");
        String emp_birth = request.getParameter("birth");
        String emp_no = request.getParameter("loginname");
        String emp_pass = request.getParameter("password");
        String emp_native = request.getParameter("native");
        String emp_tel_num = request.getParameter("tel");
        String emp_email = request.getParameter("mail");
        String emp_addr = request.getParameter("address");
        String errors = employeeService.addEmployee(emp_name, emp_sex, emp_birth, emp_no, emp_pass, emp_native, emp_tel_num, emp_email, emp_addr);
        request.setAttribute("errors", errors);
        return new ModelAndView("/manager/rsxz/AddEmployee");

    }
    @RequestMapping("/addtopemp")
    public ModelAndView addTopEmployeePage(HttpServletRequest request){

        String emp_name = request.getParameter("truename");
        String emp_sex = request.getParameter("sex");
        String emp_birth = request.getParameter("birth");
        String emp_no = request.getParameter("loginname");
        String emp_pass = request.getParameter("password");
        String emp_native = request.getParameter("native");
        String emp_tel_num = request.getParameter("tel");
        String emp_email = request.getParameter("mail");
        String emp_addr = request.getParameter("address");
        String errors = employeeService.addTopEmployee(emp_name, emp_sex, emp_birth, emp_no, emp_pass, emp_native, emp_tel_num, emp_email, emp_addr);
        request.setAttribute("errors", errors);
        return new ModelAndView("/manager/rsxz/AddTopEmployee");

    }


    @RequestMapping("/changetopemp")
    public ModelAndView changeTopEmployeePage(HttpServletRequest request){

        String emp_id = request.getParameter("id");
        String emp_name = request.getParameter("truename");
        System.out.println("name"+emp_name);
        String emp_sex = request.getParameter("sex");
        String emp_birth = request.getParameter("birth");
        String emp_pass = request.getParameter("password");
        System.out.println("pass"+emp_pass);
        String emp_native = request.getParameter("native");
        String emp_tel_num = request.getParameter("tel");
        String emp_email = request.getParameter("mail");
        String emp_addr = request.getParameter("address");
        String errors = employeeService.changeTopEmployee(emp_id, emp_name, emp_sex, emp_birth, emp_pass, emp_native, emp_tel_num, emp_email, emp_addr);
        return showTopEmployeePage(request);
    }

    @RequestMapping("/showemp")
    public ModelAndView showEmployeePage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showEmployeeByPage(request, pageNow);

        return new ModelAndView("/manager/rsxz/Employee") ;
    }

    @RequestMapping("/showtopemp")
    public ModelAndView showTopEmployeePage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showTopEmployeeByPage(request, pageNow);
        return new ModelAndView("/manager/rsxz/TopEmployee");
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

    @RequestMapping("/deltopemp")
    public ModelAndView deleteTopEmployeePage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        if(checkbox != null) {
            for (int i = 0; i < checkbox.length; i++) {
                String id = checkbox[i];
                int emp_id = Integer.parseInt(id);
                employeeService.deleteEmployee(emp_id);
            }
        }

        return showTopEmployeePage(request);
    }


    @RequestMapping("/lookemp")
    public ModelAndView lookEmployeePage(HttpServletRequest request){
        String id = request.getParameter("id");
        int emp_id = Integer.parseInt(id);
        Employee employee = employeeService.selectEmployeeByEmp_id(emp_id);
        request.setAttribute("employee", employee);
        return new ModelAndView("/manager/rsxz/EmployeeDetail");
    }

    @RequestMapping("/editemp")
    public ModelAndView editEmployeePage(HttpServletRequest request) {

        String id = request.getParameter("id");
        int emp_id = Integer.parseInt(id);
        Employee employee = employeeService.selectEmployeeByEmp_id(emp_id);
        request.setAttribute("employee", employee);
        if (employee.getType() == 0) {
            return new ModelAndView("/manager/rsxz/UpdateEmployee");
        } else {
            System.out.println("hdudhw");
            return new ModelAndView("/manager/rsxz/UpdateTopEmployee");
        }
    }
}
