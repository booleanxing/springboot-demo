package com.dx.gdou.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("hello")
    public String hello(){
        return "Hello world";
    }


    @GetMapping("users")
    public Object users(){

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from hr");
        for (Object o:list
        ) {
            log.info("{}",o);
        }

        return list;
    }



}
