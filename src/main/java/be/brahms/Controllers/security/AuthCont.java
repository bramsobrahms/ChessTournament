package be.brahms.Controllers.security;

import be.brahms.models.dtos.PlayerDTO;
import be.brahms.models.dtos.PlayerTokenDTO;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.forms.PlayerF;
import be.brahms.models.forms.PlayerLoginF;
import be.brahms.services.EmailServ;
import be.brahms.services.PlayerServ;
import be.brahms.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class AuthCont {

    private final PlayerServ playerServ;
    private final EmailServ emailServ;
    private final JwtUtils jwtUtils;

    public AuthCont(PlayerServ playerServ, EmailServ emailServ, JwtUtils jwtUtils) {
        this.playerServ = playerServ;
        this.emailServ = emailServ;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerTokenDTO> register (@RequestBody @Valid PlayerF form) {
        PlayerEnt playerRegister = playerServ.create(form.toEntity());
        String token = jwtUtils.generateToken(playerRegister);
        PlayerTokenDTO plyTokDto = PlayerTokenDTO.fromEntity(playerRegister);
        plyTokDto.setToken(token);

        emailServ.sendingEmail("brahmsisme@gmail.com", "Test", "hello,\n Voici votre identifiant: "+playerRegister.getPseudo()+" \n Votre mot de passe: "+playerRegister.getPassword()+" .");

        return ResponseEntity.ok(plyTokDto);
    }

    @PostMapping("/login")
    public ResponseEntity<PlayerTokenDTO> login(@RequestBody PlayerLoginF form) {
        PlayerEnt player = playerServ.login(form.toEntity());
        String token = jwtUtils.generateToken(player);
        PlayerTokenDTO plTokDto = PlayerTokenDTO.fromEntity(player);
        plTokDto.setToken(token);
        return ResponseEntity.ok(plTokDto);
    }
}
