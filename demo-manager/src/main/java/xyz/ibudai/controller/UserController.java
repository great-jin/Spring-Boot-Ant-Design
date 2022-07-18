package xyz.ibudai.controller;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ibudai.entity.User;
import xyz.ibudai.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/get")
    public User get(@Param("code") String code) {
        User user = userService.get(code);
        if (user == null) {
            return new User();
        }
        return user;
    }

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        String accountCode = user.getAccountCode();
        List<User> list = userService.list();
        for (User user1 : list) {
            if (accountCode.equals(user1.getAccountCode())) {
                return 2;
            }
        }
        user.setIsDelete(0);
        return userService.add(user);
    }

    @PostMapping("/login")
    public int Login(@RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getPassword();

        User loginUser = userService.get(user.getAccountCode());
        String loginUserName = loginUser.getUserName();
        String loginPassword = loginUser.getPassword();

        int flag;
        if (userName.equals(loginUserName) && password.equals(loginPassword)) {
            flag = 1;
        } else {
            flag = 2;
        }
        return flag;
    }

    @PostMapping("/update")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/delete")
    public int delete(@Param("code") String code) {
        return userService.delete(code);
    }
}