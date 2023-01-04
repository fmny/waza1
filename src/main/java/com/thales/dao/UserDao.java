package com.thales.dao;

import com.thales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    public long countByChats_id(Integer schoolId);

    public List<User> findByChats_id(Integer chatId);

}
