package com.userManagement.UserManagementSpringSecurityUse.controller;

import com.userManagement.UserManagementSpringSecurityUse.models.UserModels;
import com.userManagement.UserManagementSpringSecurityUse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @ModelAttribute
    private  void userDetails(Model m, Principal principal){
        String email=principal.getName();
        UserModels models =userRepository.findByEmail(email);
                m.addAttribute("models", models);
    }
    @GetMapping("/")
    public String home(){
        return "user/home";
    }
}
