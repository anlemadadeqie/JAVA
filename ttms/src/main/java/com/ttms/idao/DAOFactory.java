package com.ttms.idao;

import com.ttms.dao.EmployeeDAO;
import com.ttms.dao.UserDAO;


/**
 * Created by hjh on 16-10-30.
 */
public class DAOFactory {
    public static IEmployee createEmployeeDAO(){

        return  new EmployeeDAO();
    }

    public static IUser createUserDAO(){

        return new UserDAO();
    }

}
