package com.thales.controller;


import com.thales.dao.MessageDao;
import com.thales.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    @Autowired
    private MessageDao messageDao;

    @GetMapping({"/", ""})
    public List<Message> getAll(){
        return this.messageDao.findAll();
    }


    @GetMapping({"{id}/", "{id}"})
    public Message findOne(@PathVariable int id) {
        return this.messageDao.findById(id).get();
    }

    @PostMapping({"/", ""})
    public void addMessage(@RequestBody Message message) {
        this.messageDao.save(message);
    }

    @DeleteMapping({"{id}/", "{id}"})
    public void deleteMessage(@PathVariable int id) {
        this.messageDao.deleteById(id);
    }


}