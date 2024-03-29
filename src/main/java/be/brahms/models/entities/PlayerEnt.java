package be.brahms.models.entities;

import be.brahms.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table( name = "Player")
public class PlayerEnt implements UserDetails {

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

    //@Column(nullable = false, columnDefinition = "VARCHAR")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "playerWhite")
    private List<PlayerTournamentEnt> playerWhite;

    @OneToMany(mappedBy = "playerBlack")
    private List<PlayerTournamentEnt> playerBlack;


    public PlayerEnt(String email, String pseudo, LocalDate birthdate, int elo, String role, Gender gender) {
        this.email = email;
        this.pseudo = pseudo;
        this.birthdate = birthdate;
        this.elo = elo;
        this.role = role;
        this. gender = gender;
    }

    // This is generated by UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}