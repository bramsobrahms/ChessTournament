package be.brahms.services.impl;

import be.brahms.enums.Status;
import be.brahms.models.entities.RegistrationEnt;
import be.brahms.models.entities.TournamentEnt;
import be.brahms.repositories.RegistrationRepo;
import be.brahms.services.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistrationServImpl implements RegistrationServ {

    private final RegistrationRepo registrationRepo;

    @Autowired
    public RegistrationServImpl(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    @Override
    public RegistrationEnt registre(RegistrationEnt regisration) {

        while(!regisration.getTournament().getStatus().equals("WAITING")) {
            LocalDate dateNow = LocalDate.now();

            int comparaisonDate = dateNow.compareTo(regisration.getTournament().getEndDateAt());

            if(comparaisonDate > 0 && !regisration.isRegistred()) {
                System.out.println("tu peux t'inscrire");
            } else if (comparaisonDate < 0 ) {
                System.out.println("The delay is paste, you can't registre");
            }
        }
        return null;
    }

}
