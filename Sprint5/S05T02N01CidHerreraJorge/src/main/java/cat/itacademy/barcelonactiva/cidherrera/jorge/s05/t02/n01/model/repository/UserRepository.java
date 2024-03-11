package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);

}
