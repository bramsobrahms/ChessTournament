package be.brahms.Controllers;

import be.brahms.models.dtos.PlayerDTO;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.forms.PlayerF;
import be.brahms.services.PlayerServ;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PlayerCont {

    private final PlayerServ playerServ;

    public PlayerCont(PlayerServ playerServ) {
        this.playerServ = playerServ;
    }

    @PostMapping("/player")
    public ResponseEntity<PlayerEnt> create (@RequestBody @Valid PlayerF form) {
        PlayerEnt createPlayer = playerServ.create(form.toEntity());
        return ResponseEntity.ok(createPlayer);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerDTO> findPlayerById (@PathVariable Long id) {
        PlayerEnt playerId = playerServ.findById(id);
        PlayerDTO playerDTO = PlayerDTO.fromEntity(playerId);
        return ResponseEntity.ok(playerDTO);
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerEnt>> findAllPlayers () {
        List<PlayerEnt> listPlayers = playerServ.findAll();
        return ResponseEntity.ok(listPlayers);
    }

}
