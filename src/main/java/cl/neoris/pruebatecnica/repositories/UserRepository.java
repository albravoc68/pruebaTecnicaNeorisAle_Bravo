package cl.neoris.pruebatecnica.repositories;

import cl.neoris.pruebatecnica.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

}
