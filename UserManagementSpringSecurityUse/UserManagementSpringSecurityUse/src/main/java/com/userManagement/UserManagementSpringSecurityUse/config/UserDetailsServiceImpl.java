package com.userManagement.UserManagementSpringSecurityUse.config;

import com.userManagement.UserManagementSpringSecurityUse.models.UserModels;
import com.userManagement.UserManagementSpringSecurityUse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModels user =userRepository.findByEmail(email);
        if (user != null){
            return new  CustomUser(user);
        }
            throw new UsernameNotFoundException("User not available");
    }
}
