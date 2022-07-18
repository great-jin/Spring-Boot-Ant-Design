package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.ibudai.service.UserService;

public class FileController {

    @Autowired
    UserService userService;

    public void downloadFiles() {
    }

    public void downloadExcel() {
    }
}
