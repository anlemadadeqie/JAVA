package com.ttms.dao;

import com.ttms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjh on 16-11-30.
 */
@Repository("UserDAO")
public interface UserDAO {

    public void insertUser(User user);
    public void deleteUser(String emp_no);
    public void updateUser(User user);

    public User selectUserByEmp_no(String emp_no);
    public List<User> selectUserByType(int type);
    public List<User> selectUser();

}
