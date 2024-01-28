package com.anish.golu.controllers.user;

import com.anish.golu.services.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userController")
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @PostMapping("/getAll")
    public void populateFakeStore(){
        userService.getAllUsers();
    }
}
