package xyz.ibudai.util.encrypt;

import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.ibudai.util.AESUtil;

import java.util.Objects;

public class AESEncoder implements PasswordEncoder {

    /**
     * @param charSequence user input password
     */
    @Override
    public String encode(CharSequence charSequence) {
        String plain = charSequence.toString();
        try {
            return AESUtil.encrypt(plain);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param charSequence user input password
     * @param s            database password
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String plain = charSequence.toString();
        try {
            String result = AESUtil.encrypt(plain);
            return Objects.equals(result, s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
