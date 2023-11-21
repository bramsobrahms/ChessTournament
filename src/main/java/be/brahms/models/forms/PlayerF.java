package be.brahms.models.forms;

import be.brahms.enums.Gender;
import be.brahms.models.entities.PlayerEnt;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Data
public class PlayerF {

    @NotBlank
    private String email;
    @NotBlank
    private String pseudo;

    private LocalDate birthdate;
    @Min(0) @Max(3000)
    private int elo;
    @NotBlank
    private String role;

    private Gender gender;

    public PlayerEnt toEntity(){
        return new PlayerEnt(this.email, this.pseudo, this.birthdate, this.elo, this.role, this.gender);
    }

}
