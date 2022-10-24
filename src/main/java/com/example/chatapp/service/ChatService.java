package com.example.chatapp.service;


import com.example.chatapp.model.Chat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ChatService {
    List <Chat> getAllChats() ;

    Optional<Chat> getById(Long id);

    Chat create(final Chat chat);

    void delete (Long id);

    Chat update(Long id , Chat chat);


}
