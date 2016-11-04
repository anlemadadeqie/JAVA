package com.ttms.model;

import java.io.Serializable;

/**
 * Created by hjh on 16-10-30.
 */
public class User implements Serializable {

    private String emp_no;
    private String emp_pass;
    private int type;

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
