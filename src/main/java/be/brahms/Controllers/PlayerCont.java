package be.brahms.Controllers;

import be.brahms.models.dtos.PlayerDTO;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.forms.PlayerF;
import be.brahms.services.EmailServ;
import be.brahms.services.PlayerServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerCont {

    @Autowired
    private final PlayerServ playerServ;
    @Autowired
    private final EmailServ emailServ;

    public PlayerCont(PlayerServ playerServ, EmailServ emailServ) {
        this.playerServ = playerServ;
        this.emailServ = emailServ;
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerEnt> create (@RequestBody @Valid PlayerF form) {
        PlayerEnt createPlayer = playerServ.create(form.toEntity());
        emailServ.sendingEmail("brahmsisme@gmail.com", "Test", "hello,\n Voici votre identifiant: "+createPlayer.getPseudo()+" \n Votre mot de passe: "+createPlayer.getPassword()+" .");

        return ResponseEntity.ok(createPlayer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> findPlayerById (@PathVariable Long id) {
        PlayerEnt playerId = playerServ.findById(id);
        PlayerDTO playerDTO = PlayerDTO.fromEntity(playerId);
        return ResponseEntity.ok(playerDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<PlayerEnt>> listAllPlayers() {
        List<PlayerEnt> listPlayers = playerServ.findAllPlayers();
        return ResponseEntity.ok(listPlayers);
    }

    @GetMapping("/listAdmin")
    public ResponseEntity<List<PlayerEnt>> listAllAdmins() {
        List<PlayerEnt> listAdmin = playerServ.findAllAdmins();
        return ResponseEntity.ok(listAdmin);
    }

}
