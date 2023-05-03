package com.userManagement.UserManagementSpringSecurityUse.service;

import com.userManagement.UserManagementSpringSecurityUse.entities.User;
import com.userManagement.UserManagementSpringSecurityUse.models.UserModels;
import com.userManagement.UserManagementSpringSecurityUse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public ResponseEntity saveUser(UserModels userModels) {
        User user = new User();
        user.setId(userModels.getId());
        user.setAddress(userModels.getAddress());
        user.setEmail(userModels.getEmail());
        user.setPassword(userModels.getPassword());
        user.setQualification(userModels.getQualification());
        user.setFullName(userModels.getFullName());
        user.setRole(userModels.getRole());

        user.setPassword(bCryptPasswordEncoder.encode(userModels.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return new ResponseEntity<>("User registration successfully...................!", HttpStatus.OK);
    }

    public boolean checkEmail(String email){
        return userRepository.existsByEmail(email);
    }



}
