package com.gelin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 葛林 on 2017/7/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer rid;

    private String rname;

    private Set<User> users = new HashSet<>();

    private Set<Module> modules = new HashSet<>();


}
