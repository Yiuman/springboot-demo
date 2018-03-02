package kam.yiuman.demo.controller;

import kam.yiuman.demo.pojo.User;
import kam.yiuman.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getAll")
    public List<User> getAllUser(){
        List<User> user = userService.queryAll();
        return user;
    }

    @RequestMapping("addUser")
    public void addUser(User user){
        user.setUserUUID(UUID.randomUUID().toString());
        userService.save(user);
    }
}
