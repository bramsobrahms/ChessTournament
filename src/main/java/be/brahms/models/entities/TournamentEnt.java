package be.brahms.models.entities;

import be.brahms.enums.Category;
import be.brahms.enums.Status;
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

    @Column(nullable = true)
    private int maxPlayer;

    private int minElo;

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

    public TournamentEnt(String name, String place, int minPlayer, int maxPlayer, int minElo, int maxElo, Category category, boolean womenOnly) {
        this.name = name;
        this.place = place;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.minElo = minElo;
        this.maxElo = maxElo;
        this.category = category;
        this.womenOnly = womenOnly;
    }
}
