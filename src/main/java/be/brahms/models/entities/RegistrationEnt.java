package be.brahms.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table( name = "Registration")
public class RegistrationEnt {

    @Id @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEnt player;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private TournamentEnt tournament;

    @Column(nullable = false)
    private LocalDate createDateAt;

}
