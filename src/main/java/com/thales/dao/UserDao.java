package com.thales.dao;

import com.thales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDao extends JpaRepository<User, Integer> {

    User findByLogin(String login);


}
