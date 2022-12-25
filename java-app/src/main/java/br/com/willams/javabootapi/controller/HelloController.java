package br.com.willams.javabootapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${USERNAME:noname}")
    String username;

    @Value("${PASSWORD:secret}")
    String password;

    @Value("${NAME:name}")
    String name;

    @Value("${AGE:age}")
    String age;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/secret")
    public String secret() {
        return "Hello," + name +
                " You're " + age + " years old!" +
                " your username is: " + username +
                " Your password is: " + password;
    }
}
