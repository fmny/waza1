package com.thales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



//verify
@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "chat")
    @JsonIgnoreProperties("chat")
    private List<Message> messages=new ArrayList<>();

    @ManyToMany
    @JsonIgnoreProperties("chats")
    private List<User> users=new ArrayList<>();

}
