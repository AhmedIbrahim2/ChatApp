package com.example.chatapp.service;


import com.example.chatapp.model.User;
import com.example.chatapp.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService_Imp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
      return   userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User create (final User user){
       return userRepository.save(user);
    }


    @Override
    public void delete(Long id){
       userRepository.deleteById(id);
    }


    @Override
    public User update(Long id , String password){
      User existinguser = userRepository.getById(id);
        existinguser.setUser_password(password);
        return userRepository.save(existinguser);

    }


    public  User updateUser (Long id , User user){
        User existinguser = userRepository.getById(id);
        BeanUtils.copyProperties(user , existinguser , "user_id");
        return userRepository.save(existinguser);
    }



}
