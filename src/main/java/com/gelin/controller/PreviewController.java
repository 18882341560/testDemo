//package com.gelin.controller;
//
//import com.gelin.domain.Gl;
//import com.gelin.mangodb.GlDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.nio.file.Paths;
//
///**
// * Created by 葛林 on 2018/1/4.
// */
//@RequestMapping("/preview")
//@Controller
//public class PreviewController {
//
//    @Autowired
//  private GlDao glDao;
//
//    @RequestMapping("save")
//    @ResponseBody
//    public String save(){
//        Gl demoInfo = new Gl();
//        demoInfo.setName("张三");
//        demoInfo.setAge(20);
//        glDao.save(demoInfo);
//
//        demoInfo = new Gl();
//        demoInfo.setName("李四");
//        demoInfo.setAge(30);
//        glDao.save(demoInfo);
//        return "ok";
//    }
//
//
//}
