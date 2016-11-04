package com.ttms.service;

/**
 * Created by hjh on 16-11-2.
 */

import com.ttms.dao.UserDAO;
import com.ttms.idao.DAOFactory;
import com.ttms.model.User;

public class Logins{

    public  int checkLogin(String username, String password) {
        int result = -1;
        System.out.println(username);
        UserDAO userdao = (UserDAO) DAOFactory.createUserDAO();
        User user = userdao.findUserByno(username);
        if (user == null) {

            return result;
        }
        String pass = user.getEmp_pass();
        int type = user.getType();
        if (pass.equals(password)) {
            if (type == 0) {
                result = 0;
            } else {
                result = 1;
            }

        }

        return result;
    }




}
