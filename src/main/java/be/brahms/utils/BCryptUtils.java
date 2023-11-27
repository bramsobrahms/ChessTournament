package be.brahms.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptUtils {

    private final BCryptPasswordEncoder passwordEncoder;

    public BCryptUtils(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String hash(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean verify(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }

}
