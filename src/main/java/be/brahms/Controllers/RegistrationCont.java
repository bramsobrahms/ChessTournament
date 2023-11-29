package be.brahms.Controllers;

import be.brahms.models.dtos.RegistrationDTO;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.entities.RegistrationEnt;
import be.brahms.services.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationCont {

    private final RegistrationServ registrationServ;

    @Autowired
    public RegistrationCont(RegistrationServ registrationServ) {
        this.registrationServ = registrationServ;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{tournamentId}")
    public ResponseEntity<RegistrationDTO> registre(
            @PathVariable Long tournamentId,
            Authentication authentication) {
        Long userId =((PlayerEnt) authentication.getPrincipal()).getId();
        RegistrationEnt newRegistration = registrationServ.registre(userId,tournamentId);
        RegistrationDTO dto = RegistrationDTO.fromEntity(newRegistration);
        return ResponseEntity.ok(dto);
    }

}
