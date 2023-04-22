package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.entity.AuthUser;
import xyz.ibudai.service.AuthUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping("verify")
    public void authVerify(AuthUser user) {
    }

    @PostMapping("login")
    public boolean login(AuthUser user) throws Exception {
        return authUserService.login(user);
    }
}
