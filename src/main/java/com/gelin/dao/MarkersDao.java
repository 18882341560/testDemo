package com.gelin.dao;

import com.gelin.domain.Markers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 葛林 on 2017/7/21.
 */
@Mapper
@Repository
public interface MarkersDao {

    List<Markers> findAll();


}
