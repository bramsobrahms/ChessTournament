package be.brahms.models.forms;

import be.brahms.enums.Gender;
import be.brahms.models.entities.PlayerEnt;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
public class PlayerF {

    @NotNull
    private String email;
    @Min(4)
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
