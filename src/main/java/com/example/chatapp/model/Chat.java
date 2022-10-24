package com.example.chatapp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chat_id", nullable = false)
    private Long id;
    private String chat_topic ;
    private String chat_password ;

    @OneToOne(mappedBy = "chat_Message")
    private Message message_chat ;

    @ManyToMany(mappedBy = "chats")
    private List <User> users = new ArrayList<>();


    public String getChat_topic() {
        return chat_topic;
    }

    public void setChat_topic(String chat_topic) {
        this.chat_topic = chat_topic;
    }

    public String getChat_password() {
        return chat_password;
    }

    public void setChat_password(String chat_password) {
        this.chat_password = chat_password;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Chat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
