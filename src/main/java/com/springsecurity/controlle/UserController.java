package com.springsecurity.controlle;

import com.springsecurity.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<User> users =new ArrayList<>();
    @GetMapping("user")
    public List<User> users(){
        List<User> usersList =new ArrayList<>();
        User user=new User(100 ,"Rabiul", "abc@gmail.com", "123");
        User user1=new User(101 ,"Sakib", "abc@gmail.com", "123");
        User user2=new User(102 ,"Jamal", "abc@gmail.com", "123");
        usersList.add(user);
        usersList.add(user1);
        usersList.add(user2);
        return usersList;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("user")
    public User save(@RequestBody User user){
        users.add(user);
        return user;
    }

}
