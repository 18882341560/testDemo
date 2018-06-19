package com.gelin.services;

import com.gelin.domain.PageBeans;
import com.gelin.domain.User;

import java.util.List;

/**
 * Created by 葛林 on 2017/6/30.
 */

public interface UserServices {


    public String getName();

    public void insertUser(User user);

    public List<User> getUserList(int current);

    public PageBeans<User> getPage(int current);

}
