package com.gelin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 葛林 on 2017/6/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String username;

    private Integer uid;

    private String password;

    private Set<Role> roles = new HashSet<Role>();

}
