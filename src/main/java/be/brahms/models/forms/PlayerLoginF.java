package be.brahms.models.forms;

import be.brahms.models.entities.PlayerEnt;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"email", "pseudo", "password"})
@ToString(of = {"email", "pseudo", "password"})
public class PlayerLoginF {

    private String email;
    private String pseudo;
    private String password;

    public PlayerEnt toEntity() {
        PlayerEnt player = new PlayerEnt();
        player.setEmail(this.email);
        player.setPseudo(this.pseudo);
        player.setPassword((this.password));
        return player;
    }
}
