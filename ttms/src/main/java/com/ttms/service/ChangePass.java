package com.ttms.service;


import com.ttms.dao.UserDAO;
import com.ttms.idao.DAOFactory;
import com.ttms.model.User;

/**
 * Created by hjh on 16-10-31.
 */
public class ChangePass{

    public boolean changePass(User user){

        UserDAO userdaO = (UserDAO) DAOFactory.createUserDAO();
        return userdaO.update(user);

    }

}
