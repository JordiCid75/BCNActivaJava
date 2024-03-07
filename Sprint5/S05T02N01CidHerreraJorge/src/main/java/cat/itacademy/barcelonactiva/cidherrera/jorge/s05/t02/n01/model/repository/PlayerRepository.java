package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	List<Player> findByPlayerNameContaining(String name);

	Optional<Player> findByPlayerNameIgnoreCase(String name);


}
