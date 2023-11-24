package be.brahms.Controllers;

import be.brahms.models.dtos.PlayerDTO;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.forms.PlayerF;
import be.brahms.services.EmailServ;
import be.brahms.services.PlayerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerCont {

    @Autowired
    private final PlayerServ playerServ;
    @Autowired
    private final EmailServ emailServ;

    public PlayerCont(PlayerServ playerServ, EmailServ emailServ ) {
        this.playerServ = playerServ;
        this.emailServ = emailServ;
    }

    @PreAuthorize("isAuthenticated()")
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

    @PreAuthorize("hasAutority('ADMIN')")
    @GetMapping("/listAdmin")
    public ResponseEntity<List<PlayerEnt>> listAllAdmins() {
        List<PlayerEnt> listAdmin = playerServ.findAllAdmins();
        return ResponseEntity.ok(listAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerF form) {
        PlayerEnt playerUpdate = playerServ.update(id, form.toEntity());
        return ResponseEntity.ok(PlayerDTO.fromEntity(playerUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete( @PathVariable Long id) {
        playerServ.delete(id);
        emailServ.sendingEmail("brahmsisme@gmail.com", "Test Delete", "hello dear,\n Your account is delete");
        return ResponseEntity.status(200).body("Deletion success");
    }

}
