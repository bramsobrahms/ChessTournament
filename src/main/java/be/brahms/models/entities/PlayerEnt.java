package be.brahms.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table( name = "Player")
public class PlayerEnt {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String pseudo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false)
    private int elo;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, columnDefinition = "VARCHAR")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "playerWhite")
    private List<PlayerTournamentEnt> playerWhite;

    @OneToMany(mappedBy = "playerBlack")
    private List<PlayerTournamentEnt> playerBlack;


    public PlayerEnt(String email, LocalDate birthdate, int elo, String role, Gender gender) {
        this.email = email;
        this.birthdate = birthdate;
        this.elo = elo;
        this.role = role;
        this. gender = gender;
    }

}
