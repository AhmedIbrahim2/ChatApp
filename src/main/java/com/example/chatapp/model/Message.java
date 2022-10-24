package com.example.chatapp.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id ", nullable = false)
    private Long id;
    private Date message_datetime ;
    private String message_text ;

    @OneToOne
    @JoinColumn(
            name = "FK_chat_id" , referencedColumnName = "chat_id"
    )
    private Chat chat_Message ;



    public Chat getChat_Message() {
        return chat_Message;
    }

    public void setChat_Message(Chat chat_Message) {
        this.chat_Message = chat_Message;
    }

    public User getUser_message() {
        return user_message;
    }

    public void setUser_message(User user_message) {
        this.user_message = user_message;
    }

    @OneToOne
    @JoinColumn(
            name = "FK_user_id" , referencedColumnName = "user_id"
    )
    private User user_message ;

    public Message() {
    }

    public Date getMessage_datetime() {
        return message_datetime;
    }

    public void setMessage_datetime(Date message_datetime) {
        this.message_datetime = message_datetime;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
