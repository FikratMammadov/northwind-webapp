package com.fikrat.northwind.core.dataAccess;

import com.fikrat.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
