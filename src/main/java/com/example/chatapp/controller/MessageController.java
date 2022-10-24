package com.example.chatapp.controller;


import com.example.chatapp.model.Message;
import com.example.chatapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;


      @GetMapping
      public List<Message> getAll(){
        try {
            messageService.getAllMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messageService.getAllMessage();

       }



      @GetMapping
      @RequestMapping("{id}")
     public Optional<Message> getById(@PathVariable Long id){
        try {
            messageService.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messageService.getById(id);
    }




    @PostMapping
    public Message create (@RequestBody final Message message){
        try {
            messageService.create(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messageService.create(message);

    }


    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
          messageService.delete(id);
    }


    @RequestMapping(value = "{id}"  , method = RequestMethod.PUT)
    public Message update (@PathVariable Long id , @RequestBody Message message){
        try {
            messageService.update(id , message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return messageService.update(id , message);
    }
}
