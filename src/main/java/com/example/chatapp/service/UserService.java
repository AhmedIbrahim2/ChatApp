package com.example.chatapp.service;

import com.example.chatapp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getById(Long id);
     User create(final User user);

     void delete (Long id);

     User update(Long id , User user);



}
