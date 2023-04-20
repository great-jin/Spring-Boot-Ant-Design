package xyz.ibudai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/resource")
public class ResourceController {

    @GetMapping("user")
    public String demo1() {
        return "User demo.";
    }

    @GetMapping("admin")
    public String demo2() {
        return "Admin demo.";
    }

}
