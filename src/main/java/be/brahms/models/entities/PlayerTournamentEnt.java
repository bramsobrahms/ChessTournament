package be.brahms.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table( name = "PlayerTournament")
public class PlayerTournamentEnt {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PlayerEnt playerWhite;

    @ManyToOne
    private PlayerEnt playerBlack;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private TournamentEnt tournament;

    @Column(nullable = false)
    private int roundNbr;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Result result;

}
