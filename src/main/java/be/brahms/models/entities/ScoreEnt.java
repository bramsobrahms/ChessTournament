package be.brahms.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table( name = "Score")
public class ScoreEnt {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEnt player;

    private int gameTimes;

    private int winGame;

    private int loseGame;

    private double score;

}
