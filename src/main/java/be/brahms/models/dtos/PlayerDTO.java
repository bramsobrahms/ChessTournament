package be.brahms.models.dtos;

import be.brahms.enums.Gender;
import be.brahms.models.entities.PlayerEnt;

import java.time.LocalDate;

public record PlayerDTO(

        Long id,
        String pseudo,
        String email,
        LocalDate birthdate,
        int elo,
        Gender gender

) {
    public static PlayerDTO fromEntity(PlayerEnt player){
        return new PlayerDTO(player.getId(), player.getPseudo(), player.getEmail(), player.getBirthdate(), player.getElo(), player.getGender());
    }
}
