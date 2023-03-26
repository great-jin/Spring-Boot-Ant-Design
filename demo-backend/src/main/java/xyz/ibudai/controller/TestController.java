package xyz.ibudai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.entity.SysUser;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("demo1")
    public void demo1() {
    }

    @GetMapping("demo2")
    public void demo2() {
        throw new RuntimeException("Programme error.");
    }

    @GetMapping("demo3")
    public String demo3() {
        return "hello world";
    }

    @GetMapping("demo4")
    public int demo4() {
        return 1;
    }

    @GetMapping("demo5")
    public SysUser demo5() {
        SysUser user = new SysUser();
        user.setUsername("Alex");
        return user;
    }

    @GetMapping("demo6")
    public List<SysUser> demo6() {
        List<SysUser> userList = new ArrayList<>();
        SysUser user = new SysUser();
        user.setUsername("Alex");
        userList.add(user);
        return userList;
    }
}
