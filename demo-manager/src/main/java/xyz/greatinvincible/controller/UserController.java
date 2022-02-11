package xyz.greatinvincible.controller;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.greatinvincible.entity.User;
import xyz.greatinvincible.services.UserServices;

import java.util.List;

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
    public User get(@RequestParam String code){
        User user = userServices.get(code);
        if (user == null) {
            user = new User();
        }
        return user;
    }

    @PostMapping("/add")
    public int add(@RequestBody User user){
        String accountCode = user.getAccountCode();
        List<User> list = userServices.list();
        for(User user1 : list) {
            if(accountCode.equals(user1.getAccountCode())){
                return 2;
            }
        }
        user.setIsDelete(0);
        return userServices.add(user);
    }

    @PostMapping("/login")
    public int Login(@RequestBody User user){
        String userName = user.getUserName();
        String password = user.getPassword();

        User loginUser = userServices.getUser(user);
        String loginUserName = loginUser.getUserName();
        String loginPassword = loginUser.getPassword();

        int flag = 0 ;
        if (loginUser != null){
            if (userName.equals(loginUserName) && password.equals(loginPassword)){
                flag = 1;
            }
            else {
                flag = 2;
            }
        } else {
            flag = 0;
        }
        return flag;
    }

    @PostMapping("/update")
    public int update(@RequestBody User user){
        return userServices.update(user);
    }

    @PostMapping("/delete")
    public int delete(@Param("code") String code){
        return userServices.delete(code);
    }

}