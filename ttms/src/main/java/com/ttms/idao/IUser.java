package com.ttms.idao;

import com.ttms.model.Employee;
import com.ttms.model.User;

/**
 * Created by hjh on 16-10-30.
 */
public interface IUser {

    public boolean insert(User user);

    public boolean delete(User user);

    public boolean update(User user);

    public User findUserByno(String emp_no);
}
