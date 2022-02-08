package xyz.greatinvincible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.greatinvincible.entity.User;
import xyz.greatinvincible.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/list")
    public String list(){
        return userServices.list().toString();
    }

    @GetMapping("/get")
    public String getUser(@RequestParam String code){
        return userServices.get(code).toString();
    }

    @PostMapping("/update")
    public int updateUser(@RequestBody User user){
        int i = 0 ;
        i = userServices.updateUser(user);
        return i;
    }

    @PostMapping("/login")
    public int Login(@RequestBody User user){
        int flag = 0 ;
        User user_login = userServices.getUserByCode(user);
        if (user_login != null){
            if (user.getUserName().equals(user_login.getUserName()) && user.getPassword().equals(user_login.getPassword())){
                flag = 1;
            }
            else {
                flag = 0;
            }
        } else {
            flag = 0;
        }
        return flag;
    }
}