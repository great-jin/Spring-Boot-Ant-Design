package xyz.ibudai.oauth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.common.vo.AuthUser;
import xyz.ibudai.oauth.service.AuthUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

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
