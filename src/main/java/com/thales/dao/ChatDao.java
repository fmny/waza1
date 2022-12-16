package com.thales.dao;

import com.thales.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatDao extends JpaRepository<Chat, Integer> {


}
