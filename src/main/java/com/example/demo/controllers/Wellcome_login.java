package com.example.demo.controllers;

import com.example.demo.UserDetilsServis.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Wellcome_login {

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String index(@Param("username") String username
                        ,@Param("password") String password){

        userRepo.loadUserByUsername(username);

        return "";
    }


    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){

        modelAndView.setViewName("list");

        modelAndView.addObject("a",userRepo.findAll());

        return modelAndView;
    }

}
