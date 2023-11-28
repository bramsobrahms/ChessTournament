package be.brahms.Controllers;

import be.brahms.models.entities.RegistrationEnt;
import be.brahms.models.forms.RegistrationF;
import be.brahms.services.RegistrationServ;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationCont {

    private final RegistrationServ registrationServ;

    public RegistrationCont(RegistrationServ registrationServ) {
        this.registrationServ = registrationServ;
    }

    @PostMapping
    public ResponseEntity<RegistrationEnt> registre(@RequestBody @Valid RegistrationF form) {
        RegistrationEnt newRegistration = registrationServ.registre(form.toEntity());
        return ResponseEntity.ok(newRegistration);
    }
}
