package com.gelin.dao;

import com.gelin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 葛林 on 2017/6/30.
 */
@Mapper
@Repository
public interface UserDao {

    public void insertUser(User user);

    public List<User> getUserList(@Param("current") Integer current);

    public Integer getCount();

}
