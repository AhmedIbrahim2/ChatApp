package com.example.chatapp.controller;


import com.example.chatapp.model.Chat;
import com.example.chatapp.model.User;
import com.example.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chats")
public class ChatController {


    @Autowired
    private ChatService chatService ;

    @GetMapping
    public List<Chat> getall(){

        try {
            chatService.getAllChats();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return chatService.getAllChats();

    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Chat> get(@PathVariable Long id){
        try {
            chatService.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return chatService.getById(id);
    }



    @PostMapping
    public Chat create(@RequestBody final Chat chat){

        try {
            chatService.create(chat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  chatService.create(chat);


    }


    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id ){

        try {
            chatService.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @RequestMapping(value = "{id}" , method = RequestMethod.PUT)
    public Chat update (@PathVariable Long id ,@RequestBody Chat chat){
        try {
            chatService.update(id , chat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return chatService.update(id , chat);
    }
}
