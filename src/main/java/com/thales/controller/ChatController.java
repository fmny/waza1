package com.thales.controller;


import com.thales.dao.ChatDao;
import com.thales.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/chats")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {
    @Autowired
    private ChatDao chatDao;

    @GetMapping({"/", ""})
    public List<Chat> getAll(){
        return this.chatDao.findAll();
    }


    @GetMapping({"{id}/", "{id}"})
    public Chat findOne(@PathVariable int id) {
        return this.chatDao.findById(id).get();
    }

    @PostMapping({"/", ""})
    public void addChat(@RequestBody Chat chat) {
        this.chatDao.save(chat);
    }

    @DeleteMapping({"{id}/", "{id}"})
    public void deleteChat(@PathVariable int id) {
        this.chatDao.deleteById(id);
    }



}