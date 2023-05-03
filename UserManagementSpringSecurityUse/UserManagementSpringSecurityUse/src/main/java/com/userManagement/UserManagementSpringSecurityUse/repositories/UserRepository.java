package com.userManagement.UserManagementSpringSecurityUse.repositories;

import com.userManagement.UserManagementSpringSecurityUse.entities.User;
import com.userManagement.UserManagementSpringSecurityUse.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     boolean existsByEmail(String email);

     UserModels findByEmail(String email);
}
