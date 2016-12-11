package com.ttms.serviceImpl;

import com.ttms.dao.UserDAO;
import com.ttms.entity.User;
import com.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hjh on 16-11-30.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;


    @Override
    public void insertUser(User user) {

        userDAO.insertUser(user);

    }

    @Override
    public void deleteUser(String emp_no) {

        userDAO.deleteUser(emp_no);

    }

    @Override
    public void updateUser(User user) {

        userDAO.updateUser(user);

    }

    @Override
    public User selectUserByEmp_no(String emp_no) {

        User user = null;
        user = userDAO.selectUserByEmp_no(emp_no);
        return user;
    }

    @Override
    public List<User> selectUserByType(int type) {

        List<User> list = null;
        list = userDAO.selectUserByType(type);
        return list;
    }

    @Override
    public List<User> selectUser() {

        List<User> list = null;
        list = userDAO.selectUser();
        return list;
    }

}
