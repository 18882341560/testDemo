package com.gelin.dao;

import com.gelin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by 葛林 on 2017/7/3.
 */
@Mapper
@Repository
public interface UserJurisdictionDao {

    public User findByUserName(String username);


}
