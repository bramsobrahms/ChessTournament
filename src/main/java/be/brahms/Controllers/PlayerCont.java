package be.brahms.Controllers;

import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.forms.PlayerF;
import be.brahms.services.PlayerServ;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerCont {

    private final PlayerServ playerServ;

    public PlayerCont(PlayerServ playerServ) {
        this.playerServ = playerServ;
    }

    @PostMapping
    public ResponseEntity<PlayerEnt> create (@RequestBody @Valid PlayerF form) {
        PlayerEnt createPlayer = playerServ.create(form.toEntity());
        return ResponseEntity.ok(createPlayer);
    }
}
