package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.services.ISucursalService;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.services.SucursalServiceImpl;

@RestController
public class SucursalController {
	@Autowired
	ISucursalService sucursalService;

	@GetMapping("/sucursal/getAll")
	public ResponseEntity<List<SucursalDTO>> getAllSucursals() {
		try {
			List<SucursalDTO> sucursals = new ArrayList<SucursalDTO>();

			sucursals = sucursalService.getAllSucursales();

			if (sucursals.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(sucursals, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/sucursal/getOne/{id}")
	public ResponseEntity<SucursalDTO> getSucursalById(@PathVariable("id") int id) {
		Optional<SucursalDTO> sucursalData = Optional.ofNullable(sucursalService.getSucursalById(id));

		if (sucursalData.isPresent()) {
			return new ResponseEntity<>(sucursalData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/sucursal/add")
	public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursal) {
		try {
			SucursalDTO _sucursal = sucursalService.createSucursal(sucursal);
			return new ResponseEntity<>(_sucursal, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sucursal/update")
	public ResponseEntity<SucursalDTO> updateSucursal(@RequestBody SucursalDTO sucursal) {
		Optional<SucursalDTO> sucursalData = Optional.ofNullable(sucursalService.updateSucursal(sucursal));

		if (sucursalData.isPresent()) {
			return new ResponseEntity<>(sucursalData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/sucursal/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFSucursal(@PathVariable("id") int id) {
		try {
			sucursalService.deleteSucursalById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
