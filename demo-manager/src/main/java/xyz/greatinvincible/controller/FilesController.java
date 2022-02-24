package xyz.greatinvincible.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/files")
public class FilesController {

    @PostMapping("/upload")
    public boolean Upload(Object obj) {

        return false;
    }
}
