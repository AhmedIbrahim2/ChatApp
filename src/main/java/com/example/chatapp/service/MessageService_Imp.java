package com.example.chatapp.service;

import com.example.chatapp.model.Message;
import com.example.chatapp.repository.MessageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService_Imp implements MessageService{

    @Autowired
    MessageRepository messageRepository ;
    @Override
    public List<Message> getAllMessage() {

     return messageRepository.findAll();
    }


    @Override
    public Optional<Message> getById(Long id) {

        return messageRepository.findById(id);

    }


    @Override
    public Message create(final Message message) {
        return messageRepository.save(message);
    }


    @Override
    public void  delete(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message update(Long id, Message message) {
        Message existingmessage = messageRepository.getById(id);
        BeanUtils.copyProperties(message ,existingmessage ,"message_id");
        return messageRepository.save(existingmessage);
    }
}
