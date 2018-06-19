package com.gelin.services.impl;

import com.gelin.dao.UserJurisdictionDao;
import com.gelin.domain.User;
import com.gelin.services.UserJurisdictionServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 葛林 on 2017/7/3.
 */
@Service
public class UserJurisdictionServicesImpl implements UserJurisdictionServices {

    @Resource
    private UserJurisdictionDao userJurisdictionDao;


    @Override
    public User findByUserName(String username) {
        return userJurisdictionDao.findByUserName(username);
    }
}
