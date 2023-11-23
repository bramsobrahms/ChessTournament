package be.brahms.models.forms;

import be.brahms.enums.Category;
import be.brahms.models.entities.TournamentEnt;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class TournamentF {

    @NotNull
    private String name;
    private String place;
    @NotNull @Min(2)
    private int minPlayer;
    @NotNull @Max(32)
    private int maxPlayer;
    @Min(0)
    private int minElo;
    @Max(3000)
    private int maxElo;
    private Category Category;
    private boolean womenOnly;

    public TournamentEnt toEntity() {
        return new TournamentEnt(this.name, this.place, this.minPlayer, this.maxPlayer, this.minElo, this.maxElo, this.Category, this.womenOnly);
    }

}
