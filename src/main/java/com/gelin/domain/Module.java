package com.gelin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by 葛林 on 2017/7/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {

    private Integer mid;

    private String mname;

    private Set<Role> roles;

}
