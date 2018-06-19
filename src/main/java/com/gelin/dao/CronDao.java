package com.gelin.dao;

import com.gelin.domain.Cron;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by 葛林 on 2017/7/19.
 */
@Mapper
@Repository
public interface CronDao {

    public Cron findCron(Integer id);

}
