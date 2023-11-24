package be.brahms.models.dtos;

import be.brahms.enums.Gender;
import be.brahms.models.entities.PlayerEnt;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"id","email","role"})
@ToString(of = {"id","email","role"})
public class PlayerTokenDTO {

    private Long id;
    private String pseudo;
    private String email;
    private LocalDate birthdate;
    private int elo;
    private Gender gender;
    private String token;

    public static PlayerTokenDTO fromEntity(PlayerEnt player) {
        PlayerTokenDTO plyDto = new PlayerTokenDTO();
        plyDto.setId(player.getId());
        plyDto.setPseudo(player.getPseudo());
        plyDto.setEmail(player.getEmail());
        plyDto.setBirthdate(player.getBirthdate());
        plyDto.setElo(player.getElo());
        plyDto.setGender(player.getGender());
        return plyDto;
    }
}
