package be.brahms.models.forms;

import be.brahms.enums.Gender;
import be.brahms.models.entities.PlayerEnt;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerF {

    @NotNull
    private String email;
    @NotBlank @Size( min = 4, max = 30 )
    private String pseudo;
    @NotNull
    private LocalDate birthdate;
    @Min(0) @Max(3000)
    private int elo;
    @NotNull
    private String role;
    @NotNull
    private Gender gender;

    public PlayerEnt toEntity(){
        return new PlayerEnt(this.email, this.pseudo, this.birthdate, this.elo, this.role, this.gender);
    }

}
