package com.ttms.serviceImpl;

import com.ttms.dao.EmployeeDAO;
import com.ttms.entity.Employee;
import com.ttms.entity.Play;
import com.ttms.service.CheckService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by hjh on 16-12-1.
 */
@Service("CheckServiceImpl")
public class CheckServiceImpl implements CheckService {


    @Autowired
    EmployeeDAO employeeDAO;


    @Override
    public int checkLogin(String emp_no, String emp_pass) {
        int type = -1;
        Employee employee = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee == null){

            return type;
        }
        String pass = employee.getEmp_pass();
        if(pass.equals(emp_pass)){

            return employee.getType();
        }
        return type;
    }

    @Override
    public int checkRegister(String emp_no, String emp_pass, String emp_email) {

        int result = -1;
        Employee employee = null;
        employee = employeeDAO.selectEmployeeByEmp_no(emp_no);
        if(employee == null){
            Employee employee1 = new Employee();
            employee1.setEmp_no(emp_no);
            employee1.setEmp_pass(emp_pass);
            employee1.setType(0);
            employee1.setEmp_email(emp_email);
            employeeDAO.insertEmployee(employee1);
            result = 0;

        }
        return result;
    }

    @Override
    public String changePass(HttpServletRequest request) {

        String paramName = "";
        String paramValue = "";
        String errors = "";
        Employee employee = new Employee();

        //创建对象
        DiskFileItemFactory dff = new DiskFileItemFactory();
        //指定在内存中缓存数据的大小
        dff.setSizeThreshold(1024000);
        //创建上传对象
        ServletFileUpload sfu = new ServletFileUpload(dff);
        //指定单个上传文件的最大尺寸
        sfu.setFileSizeMax(1024*1024*2);

        try{
            List<FileItem> uploaditems = sfu.parseRequest(request);

            for(FileItem fileItem : uploaditems){

                paramName = fileItem.getFieldName();


                if(fileItem.isFormField()){

                    paramValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");

                    if("pa1".equals(paramName)){

                        employee.setEmp_pass(paramValue);
                        String emp_no = (String)request.getSession().getAttribute("names");
                        Employee employee１ = employeeDAO.selectEmployeeByEmp_no(emp_no);
                        String emp_name = employee１.getEmp_name();
                        String emp_tel_num = employee１.getEmp_tel_num();
                        String emp_addr = employee１.getEmp_addr();
                        String emp_email = employee１.getEmp_email();
                        String emp_sex = employee１.getEmp_sex();
                        String emp_birth = employee１.getEmp_birth();
                        String emp_native = employee１.getEmp_native();
                        int emp_id = employee１.getEmp_id();
                        employee.setEmp_no(emp_no);
                        employee.setType(0);
                        employee.setEmp_id(emp_id);
                        employee.setEmp_name(emp_name);
                        employee.setEmp_tel_num(emp_tel_num);
                        employee.setEmp_addr(emp_addr);
                        employee.setEmp_email(emp_email);
                        employee.setEmp_sex(emp_sex);
                        employee.setEmp_birth(emp_birth);
                        employee.setEmp_native(emp_native);
                    }

                }else{

                    Long size = fileItem.getSize();
                    String fileName = fileItem.getName();
                    String load = request.getServletContext().getRealPath("/");
                    load += "statics/pic/";
                    File file = new File(load+fileName);
                    fileItem.write(file);
                    employee.setEmp_pic("/pic/"+fileName);

                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeDAO.updateEmployee(employee);
        errors = "更新成功！";
        return errors;
    }

    @Override
    public String updatePic(HttpServletRequest request) {

        String paramName = "";
        String paramValue = "";
        String errors = "";
        Employee employee = new Employee();

        //创建对象
        DiskFileItemFactory dff = new DiskFileItemFactory();
        //指定在内存中缓存数据的大小
        dff.setSizeThreshold(1024000);
        //创建上传对象
        ServletFileUpload sfu = new ServletFileUpload(dff);
        //指定单个上传文件的最大尺寸
        sfu.setFileSizeMax(1024*1024*2);

        try{
            List<FileItem> uploaditems = sfu.parseRequest(request);

            for(FileItem fileItem : uploaditems){

                paramName = fileItem.getFieldName();


                if(fileItem.isFormField()){

                    paramValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");

                        String emp_no = (String)request.getSession().getAttribute("names");
                        Employee employee１ = employeeDAO.selectEmployeeByEmp_no(emp_no);
                        int emp_id = employee１.getEmp_id();
                        String emp_pass = employee１.getEmp_pass();
                        employee.setEmp_no(emp_no);
                        employee.setEmp_pass(emp_pass);
                        employee.setType(1);
                        employee.setEmp_id(emp_id);

                }else{

                    Long size = fileItem.getSize();
                    String fileName = fileItem.getName();
                    String load = request.getServletContext().getRealPath("/");
                    load += "statics/pic/";
                    File file = new File(load+fileName);
                    fileItem.write(file);
                    employee.setEmp_pic("/pic/"+fileName);

                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeDAO.updateEmployee(employee);
        errors = "更新成功！";
        return errors;

    }

}
