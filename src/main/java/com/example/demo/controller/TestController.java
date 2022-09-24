package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    /*
    * 这是一个练习
    */
    @RequestMapping("/hello")
    public String SayHello(){
        String hello = "hello world !";
        return hello;
    }
}
