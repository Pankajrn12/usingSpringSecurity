package com.userManagement.UserManagementSpringSecurityUse.controller;

import com.userManagement.UserManagementSpringSecurityUse.entities.User;
import com.userManagement.UserManagementSpringSecurityUse.models.UserModels;
import com.userManagement.UserManagementSpringSecurityUse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.awt.geom.RectangularShape;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signin")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @Autowired
    UserService userService;


    @PostMapping("/saveUser")
    public ResponseEntity saveUser(@ModelAttribute UserModels userModels, HttpSession session){
        return userService.saveUser(userModels);
    }

}
