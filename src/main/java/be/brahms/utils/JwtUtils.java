package be.brahms.utils;

import be.brahms.config.JwtConf;
import be.brahms.models.entities.PlayerEnt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final JwtConf config; // Configuration for JWT operations
    private final JwtParser parser; // JWT parser for decoding tokens
    private final JwtBuilder builder; // JWT builder for generating tokens

    /**
     * Constructs a JwtUtils instance with the provided configuration.
     * @param config The JwtConf object containing configuration details.
     */
    public JwtUtils(JwtConf config) {
        this.config = config;
        this.parser = Jwts.parserBuilder().setSigningKey(config.secretKey).build(); // Reade the parse JWT
        this.builder = Jwts.builder().signWith(config.secretKey); // Sign with JWT
    }

    /**
     * Generates a JWT for the given PlayerEnt object.
     * @param player The PlayerEnt object containing player information.
     * @return A string representation of the generated JWT.
     */
    public String generateToken(PlayerEnt player) {
        return builder
                .claim("email", player.getEmail()) // claim => revendication ou réclamations
                .setIssuedAt(new Date()) // Define actual date
                .setExpiration(new Date(System.currentTimeMillis() + config.expiretAt * 1000L)) // Expirate Date convert in MiliSecondes
                .compact(); // Create the String
    }

    /**
     * Retrieves the claims (information) from a given JSON Web Token (JWT) string.
     * @param token The JWT string from which to extract claims.
     * @return A Claims object representing the claims extracted from the JWT.
     */
    public Claims getClaims(String token) {
        return parser.parseClaimsJws(token).getBody();
    }

    public Long getId(String token){
        return getClaims(token).get("id", Long.class);
    }
    public String getEmail(String token){
        return getClaims(token).get("email", String.class);
    }
    public String getRole(String token){
        return getClaims(token).get("role", String.class);
    }

    /**
     * Checks the validity of a JSON Web Token (JWT).
     * @param token The JWT string to be validated.
     * @return True if the token is valid; false otherwise.
     */
    public boolean isValid(String token) {
        Claims claims = getClaims(token);
        Date dateNow = new Date();
        return getRole(token) != null && dateNow.after(claims.getIssuedAt()) && dateNow.before(claims.getExpiration());
    }

}
