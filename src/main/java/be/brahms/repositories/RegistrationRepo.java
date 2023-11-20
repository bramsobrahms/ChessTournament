package be.brahms.repositories;

import be.brahms.models.entities.RegistrationEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationEnt, Long> {
}
