package be.brahms.services.impl;

import be.brahms.exceptions.player.NotFoundPlayerException;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.repositories.PlayerRepo;
import be.brahms.services.PlayerServ;
import be.brahms.services.security.GeneratePwd;
import be.brahms.utils.BCryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServImpl implements PlayerServ {

    private final PlayerRepo playerRepo;
    private final BCryptUtils bCryptUtils;

    @Autowired
    public PlayerServImpl(PlayerRepo playerRepo, BCryptUtils bCryptUtils) {
        this.playerRepo = playerRepo;
        this.bCryptUtils = bCryptUtils;
    }

    @Override
    public PlayerEnt create(PlayerEnt player) {

        if ( player.getElo() == 0 ) {
            player.setElo(1200);
        }

//      Genere un pseudo automatiquement
//      Il prend l'email et retir tout ce qui y après @

//      String[] emailPlayer = player.getEmail().split("@");
//
//      if(emailPlayer.length > 0){
//          String pseudo = emailPlayer[0];
//          player.setPseudo(pseudo);
//      }

        String passwordGenerate = GeneratePwd.GeneratePassword(8);
        String passwordHashBCrypt = bCryptUtils.hash(passwordGenerate);
        System.out.println(passwordGenerate);
        player.setPassword(passwordHashBCrypt);


        return playerRepo.save(player);
    }

    @Override
    public PlayerEnt findById(Long id) {
        return playerRepo.findById(id).orElseThrow(NotFoundPlayerException::new);
    }

    @Override
    public List<PlayerEnt> findAllPlayers() {
        return playerRepo.findAllPlayers();
    }


    public List<PlayerEnt> findAllAdmins() {
        return playerRepo.findAllAdmins();
    }

}
