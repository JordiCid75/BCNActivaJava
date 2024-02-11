package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.services.IFruitaService;

@RestController
public class FruitaController {

	@Autowired
	private IFruitaService fruitaService;

	@GetMapping("/fruita/getAll")
	public ResponseEntity<List<Fruita>> getAllFruites(@RequestParam(required = false) String nom) {
        return ResponseEntity.ok().body(fruitaService.getAllFruites());
	}

	@GetMapping("/fruita/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(fruitaService.getFruitaById(id));
	}

	@PostMapping("/fruita/add")
	public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruitaDto) {
		Fruita newFruita = fruitaService.createFruita(fruitaDto);
        return new ResponseEntity<>(newFruita, HttpStatus.CREATED);
	}

	@PutMapping("/fruita/update/{id}")
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruitaDto) {
		return ResponseEntity.ok().body(fruitaService.updateFruita(id,fruitaDto));
	}

	@DeleteMapping("/fruita/delete/{id}")
	public ResponseEntity<String> deleteFruita(@PathVariable("id") int id) {
		fruitaService.deleteFruitaById(id);
        return new ResponseEntity<>(("Fruita deleted successfully- Fruita ID:" + id), HttpStatus.OK);
	}

}
