package be.brahms.models.dtos;

import be.brahms.models.entities.RegistrationEnt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class RegistrationDTO {
    private Long id;
    private Long playerId;
    private Long tournamentId;
    private LocalDate createDateAt;
    private boolean registred;

    public static RegistrationDTO fromEntity(RegistrationEnt registration) {
        RegistrationDTO regstionDTO = new RegistrationDTO();
        regstionDTO.setId(registration.getId());
        regstionDTO.setPlayerId(registration.getPlayer().getId());
        regstionDTO.setTournamentId(registration.getTournament().getId());
        regstionDTO.setCreateDateAt(registration.getCreateDateAt());
        regstionDTO.setRegistred(registration.isRegistred());
        return regstionDTO;
    }
}
