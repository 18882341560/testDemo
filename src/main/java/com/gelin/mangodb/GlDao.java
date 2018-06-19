package com.gelin.mangodb;

import com.gelin.domain.Gl;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by 葛林 on 2018/1/11.
 */
public interface GlDao extends MongoRepository<Gl, Integer> {
    Gl findByName(String name);
}
