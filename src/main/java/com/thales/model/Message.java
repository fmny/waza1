package com.thales.model;

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
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne
    private User author;

    @NonNull
    private String contents;


    @ManyToMany(mappedBy = "messagesReceived")
    private List<User> receivers=new ArrayList<>();

    @ManyToOne
    private Chat chat;

}
