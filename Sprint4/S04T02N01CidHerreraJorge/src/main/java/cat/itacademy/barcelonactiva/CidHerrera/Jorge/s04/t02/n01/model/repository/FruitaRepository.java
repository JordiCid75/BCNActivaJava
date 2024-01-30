package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.domain.Fruita;

public interface FruitaRepository extends JpaRepository<Fruita, Integer> {

	List<Fruita> findByNomContaining(String nom);
}
