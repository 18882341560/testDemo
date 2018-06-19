package com.gelin.services.impl;

import com.gelin.dao.UserDao;
import com.gelin.domain.PageBeans;
import com.gelin.domain.User;
import com.gelin.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 葛林 on 2017/6/30.
 */
@Service
@Transactional
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserDao userDao;


    public List<User> getUserList(int current) {
        return userDao.getUserList(current);
    }

    @Override
    public PageBeans<User> getPage(int current) {
        return new PageBeans<User>(userDao.getUserList(current), current, 5, userDao.getCount());
    }

    @Override
    public String getName() {
        return "葛林";
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

}
