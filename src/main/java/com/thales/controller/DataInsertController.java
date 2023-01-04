package com.thales.controller;

import com.thales.dao.ChatDao;
import com.thales.dao.MessageDao;
import com.thales.dao.UserDao;
import com.thales.model.Chat;
import com.thales.model.Message;
import com.thales.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/datainsert")
public class DataInsertController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ChatDao chatDao;

    @Autowired
    private MessageDao messageDao;


    @GetMapping({"/", ""})
    public void insert(){
        getList();
    }

    final public void getList() {

        //on Crée en 1er lieu les Chat
        Chat chat1=new Chat();
        Chat chat2=new Chat();

        chat1.setName("chat1");
        chat2.setName("chat2");

        //on sauvegarde les chats
        this.chatDao.save(chat1);
        this.chatDao.save(chat2);

        //on crée ensuite les Users
        User user1=new User("monPseudo","t","");
        User user2=new User("pseudo1","log1","mdp1");
        User user3=new User("pseudo2","log2","mdp2");
        User user4=new User("pseudo3","log3","mdp3");
        User user5=new User("pseudo4","log4","mdp4");
        User user6=new User("pseudo5","log5","mdp5");
        User user7=new User("pseudo6","log6","mdp6");

        //on sauvegarde les Users
        this.userDao.save(user1);
        this.userDao.save(user2);
        this.userDao.save(user3);
        this.userDao.save(user4);
        this.userDao.save(user5);
        this.userDao.save(user6);
        this.userDao.save(user7);

        //on ajoute les Users dans les Chats via la table de liaison
        chat1.getUsers().add(user1);
        chat1.getUsers().add(user2);
        chat1.getUsers().add(user3);
        chat1.getUsers().add(user4);
        chat2.getUsers().add(user5);
        chat2.getUsers().add(user6);
        chat2.getUsers().add(user7);

        //on crée les messages
        Message message11=new Message(user1,"message 1 de user1");
        Message message12=new Message(user1,"message 2 de user1");
        Message message13=new Message(user1,"message 3 de user1");

        Message message21=new Message(user2,"message 1 de user2");
        Message message22=new Message(user2,"message 2 de user2");

        Message message3=new Message(user3,"message 1 de user3");
        Message message4=new Message(user4,"message 1 de user4");

        //on crée les messages reçus
        /*
        Message messageReceived11=new Message(user3,"messageReceived 1 par user1 envoyé par user 3");
        Message messageReceived12=new Message(user2,"messageReceived 1 par user1 envoyé par  user 2");
        Message messageReceived21=new Message(user2,"messageReceived 2 par user1 envoyé par user2");
        Message messageReceived3=new Message(user1,"messageReceived 1 par user3 envoyé par user1");

        this.messageDao.save(messageReceived11);
        this.messageDao.save(messageReceived12);
        this.messageDao.save(messageReceived21);
        this.messageDao.save(messageReceived3);
*/

        //on associe les Messages aux Chats
        message11.setChat(chat1);
        message12.setChat(chat1);
        message13.setChat(chat1);
        message21.setChat(chat1);
        message22.setChat(chat1);
        message3.setChat(chat2);
        message4.setChat(chat2);



        //on sauvegarde les messages
        this.messageDao.save(message11);
        this.messageDao.save(message12);
        this.messageDao.save(message13);
        this.messageDao.save(message21);
        this.messageDao.save(message22);
        this.messageDao.save(message3);
        this.messageDao.save(message4);


        //on associe les Messages aux Users (qui reçoit quoi)
        //je retire pour dire que ceux qui recoivent le message sont les personnes du chat
        /*
        user1.getMessagesReceived().add(message11);
        user1.getMessagesReceived().add(message12);
        user1.getMessagesReceived().add(message13);
        user1.getMessagesReceived().add(message21);
        user1.getMessagesReceived().add(message22);
        user1.getMessagesReceived().add(message3);
        user1.getMessagesReceived().add(message4);

        user1.getMessagesReceived().add(messageReceived11);
        user1.getMessagesReceived().add(messageReceived12);
        user1.getMessagesReceived().add(messageReceived21);
        user1.getMessagesReceived().add(messageReceived3);



        //on associe les messages aux Chats
        messageReceived11.setChat(chat1);
        messageReceived12.setChat(chat1);
        messageReceived21.setChat(chat1);
        messageReceived3.setChat(chat1);

        //on sauvegarde les messages
        this.messageDao.save(messageReceived11);
        this.messageDao.save(messageReceived12);
        this.messageDao.save(messageReceived21);
        this.messageDao.save(messageReceived3);
*/
        //On ajoute des amis aux users
        user1.getFriends().add(user2);
        user1.getFriends().add(user3);
        user1.getFriends().add(user4);

        user2.getFriends().add(user1);
        user2.getFriends().add(user5);
        user2.getFriends().add(user6);

        this.userDao.save(user1);
        this.userDao.save(user2);


    }

}
