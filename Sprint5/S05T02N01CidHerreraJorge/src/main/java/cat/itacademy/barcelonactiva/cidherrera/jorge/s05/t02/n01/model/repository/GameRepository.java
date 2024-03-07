package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Game;

@Repository
public interface GameRepository extends
//JpaRepository<Game, Integer> 
		MongoRepository<Game, String> {
	List<Game> findAllByPlayerId(int id);

}
