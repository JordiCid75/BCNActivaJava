package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.exceptions.FruitaAlreadyExistException;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.exceptions.FruitaNotFoundException;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.repository.FruitaRepository;

@Service
public class FruitaServiceImpl implements IFruitaService {
	private FruitaRepository fruitaRepository;

	@Override
	public List<Fruita> getAllFruites() {
		return fruitaRepository.findAll();
	}

	@Override
	public Fruita getFruitaById(int id) {
		return fruitaRepository.findById(id)
				.orElseThrow(() -> new FruitaNotFoundException("Fruita Not Found with ID: " + id));
	}

	@Override
	public Fruita createFruita(Fruita fruita) {
		fruitaRepository.findByNameIgnoreCase(fruita.getNom()).ifPresent(fr -> {
			throw new FruitaAlreadyExistException("Already exist fruita with given name:" + fruita.getNom());
		});
		return fruitaRepository.save(fruita);
	}

	@Override
	public Fruita updateFruita(int id, Fruita updatedFruita) {
		if (id == null) {
			throw new IllegalArgumentException("Fruita ID cannot be null");
		}
		Fruita existingFruita = fruitaRepository.findById(id)
				.orElseThrow(() -> new FruitaNotFoundException("Fruita Not Found with ID: " + id));
		existingFruita.setNom(updatedFruita.getNom());
		return fruitaRepository.save(existingFruita);
	}

	@Override
	public void deleteFruitaById(int id) throws FruitaNotFoundException {
		Fruita existingFruita = fruitaRepository.findById(id)
				.orElseThrow(() -> new FruitaNotFoundException("Fruita Not Found with ID: " + id));
		fruitaRepository.deleteById(existingFruita.getId());
	}

}
