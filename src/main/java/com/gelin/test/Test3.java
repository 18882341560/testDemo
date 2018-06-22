package com.gelin.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author green
 * @date 2018/6/22/022
 */
public class Test3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("//asd","//asdasd");
        list.stream()
            .map( s -> s.replaceAll("//",""))
            .forEach(System.out::println);
    }


}
