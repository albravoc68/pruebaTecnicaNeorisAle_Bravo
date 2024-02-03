package cl.neoris.pruebatecnica.repositories;

import cl.neoris.pruebatecnica.model.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {

}
