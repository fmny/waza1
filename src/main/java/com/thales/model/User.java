package com.thales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String pseudo;

    @NonNull
    private String login;

    @NonNull
    private String password;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    //JsonIgnore partout en dessous de mappedBy
    private List<Message> messagesWrote =new ArrayList<>();

/*
    @ManyToMany
    @JsonIgnore
    //si je retire le JsonIgnore: la requete:
    //http://localhost:8080/waza/api/chats
    //donne une erreur
    private List<Message> messagesReceived=new ArrayList<>();
*/

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties({"users","messages"})
    private List<Chat> chats=new ArrayList<>();

    @OneToMany
    @JsonIgnore
    private List<User> friends=new ArrayList<>();




}
