package com.example.chatapp.service;


import com.example.chatapp.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MessageService {
    List<Message> getAllMessage();

    Optional<Message> getById(Long id);

    Message create (final Message message);


    void delete (Long id);

    Message update (Long id , Message message);


}
