    package com.example.chatapp.controller;


    import com.example.chatapp.model.User;
    import com.example.chatapp.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @Autowired
        private UserService userService ;

   @GetMapping
      public List<User> getall(){

       try {
           return   userService.getAllUsers();

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

   @GetMapping
   @RequestMapping("{id}")
   public Optional<User> get(@PathVariable Long id){
       try {
           return   userService.getById(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }



   @PostMapping
   public User create(@RequestBody final User user){

       try {
           return   userService.create(user);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

   }


  @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id ){

       try {
           userService.delete(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
  }



  @RequestMapping(value = "{id}" , method = RequestMethod.PUT)
  public User update (@PathVariable Long id ,@RequestBody String password ){
       try {
           return    userService.update(id , password);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

  }


  @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
        public User updateUser (@PathVariable Long id , @RequestBody User user){
       try {
           return userService.updateUser(id , user);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
  }








    }
