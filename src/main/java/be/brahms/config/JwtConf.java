package be.brahms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConf {

    private byte[] secret = "HelloDeveloppersBackJavaAndFrontAngularWhoUseIntelliJ".getBytes(StandardCharsets.UTF_8);
    public int expiretAt = 86400;
    public SecretKey secretKey = new SecretKeySpec(secret, "HmacSHA384");

}
