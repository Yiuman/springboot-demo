package kam.yiuman.bigeyes.controller;

import kam.yiuman.bigeyes.common.validate.annotation.NotNull;
import kam.yiuman.bigeyes.pojo.User;
import kam.yiuman.bigeyes.service.UserService;
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
    public List<User> getAllUser() {
        List<User> user = userService.queryAll();
        return user;
    }

    @RequestMapping("addUser")
    public void addUser(@NotNull User user) {
        if (user != null) {
            user.setUserUUID(UUID.randomUUID().toString());
            userService.save(user);
        }
    }
}
