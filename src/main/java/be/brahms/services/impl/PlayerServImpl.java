package be.brahms.services.impl;

import be.brahms.exceptions.player.NotFoundPlayerException;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.repositories.PlayerRepo;
import be.brahms.services.PlayerServ;
import be.brahms.services.security.GeneratePwd;
import be.brahms.utils.BCryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<PlayerEnt> findAllAdmins() {
        return playerRepo.findAllAdmins();
    }

    @Override
    public PlayerEnt update(Long id, PlayerEnt player) {
        PlayerEnt playerUptdById = playerRepo.findById(id).orElseThrow(NotFoundPlayerException::new);
        playerUptdById.setEmail(player.getEmail());
        playerUptdById.setPseudo(player.getPseudo());
        playerUptdById.setBirthdate(player.getBirthdate());
        playerUptdById.setGender(player.getGender());

        return playerRepo.save(playerUptdById);
    }

    @Override
    public void delete(Long id){
        PlayerEnt playerDelete = playerRepo.findById(id).orElseThrow(NotFoundPlayerException::new);
        playerRepo.delete(playerDelete);
    }

    @Override
    public PlayerEnt login(PlayerEnt player) {
        PlayerEnt playerEmailPseudo = playerRepo.findEmailOrPseudo(player.getEmail(), player.getPseudo()).orElseThrow();

        if(!bCryptUtils.verify(player.getPassword(), playerEmailPseudo.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return playerEmailPseudo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return playerRepo.findByEmail(email).orElseThrow();
    }

//    @Override
//    public PlayerEnt login(PlayerEnt player) {
//        PlayerEnt existingPlayer = playerRepo.findByEmail(player.getEmail()).orElseThrow();
//        if(!bCryptUtils.verify(player.getPassword(), existingPlayer.getPassword())) {
//            throw new RuntimeException("Wrong password");
//        }
//        return existingPlayer;
//    }

}
