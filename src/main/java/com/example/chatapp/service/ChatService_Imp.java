package com.example.chatapp.service;

        import com.example.chatapp.model.Chat;

        import com.example.chatapp.repository.ChatRepository;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class ChatService_Imp implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    public List<Chat> getAllChats(){
        return chatRepository.findAll();
    }

    @Override
    public Optional<Chat> getById(Long id) {
        return chatRepository.findById(id);
    }



    @Override
    public Chat create (final Chat chat){
        return chatRepository.save(chat);
    }



    public void delete(Long id){
      chatRepository.deleteById(id);    }


    @Override
    public Chat update(Long id, Chat chat){
        Chat existingchat = chatRepository.getById(id);
        BeanUtils.copyProperties(chat ,existingchat ,"chat_id");
        return chatRepository.save(existingchat);

    }



}
