package com.thales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne
    private User author;

    @NonNull
    private String contents;

    //A voir si on supprime, le chat fait deja office de receveurs
    //@ManyToMany(mappedBy = "messagesReceived")
    //@JsonIgnore
    //private List<User> receivers=new ArrayList<>();

    @ManyToOne
    @JsonIgnoreProperties({"messages","users"})
    private Chat chat;


    private LocalDateTime dateMessage = LocalDateTime.now();

}
