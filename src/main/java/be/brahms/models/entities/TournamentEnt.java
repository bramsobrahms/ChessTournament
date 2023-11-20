package be.brahms.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table( name = "Tournament")
public class TournamentEnt {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String place;

    @Column(nullable = false)
    private int minPlayer;

    @Column(nullable = false)
    private int maxPlayer;

    @Column(nullable = false)
    private int minElo;

    @Column(nullable = false)
    private int maxElo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private int roundNbr;

    @Column(nullable = false)
    private boolean womenOnly;

    @Column(nullable = false)
    private LocalDate endDateAt;

    @Column(nullable = false)
    private LocalDate createDateAt;

    @Column(nullable = false)
    private LocalDate updateDateAt;

    @Column(nullable = false)
    private int currentRound;

    @OneToMany(mappedBy = "tournament")
    private List<RegistrationEnt> regisTournaments;

    @OneToMany(mappedBy = "tournament")
    private List<PlayerTournamentEnt> playerTournaments;

}
