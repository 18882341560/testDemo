package com.gelin.controller;

import com.gelin.dao.MarkersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * Created by 葛林 on 2017/7/21.
 */
@Controller
@RequestMapping("/marker")
public class MarkersController {

    @Autowired
    private MarkersDao markersDao;

    @RequestMapping("/aaa")
    public String getMarkers(HttpSession session) {
        session.setAttribute("marker", markersDao.findAll());
        return "ditu2";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }

}
