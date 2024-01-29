package cat.itacademy.barcelonactiva.cidherrera.jorge.s04.t01.n01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping(value = "/HelloWorld")
	public String saluda(@RequestParam(name = "nom", defaultValue = "UNKNOWN") String nom) {
		return "Hola " + nom + ". Estàs executant un projecte Maven.";
	}

	@GetMapping(value = { "/HelloWorld2", "/HelloWorld2/{nom}" })
	public String saluda2(@PathVariable(name = "nom", required = false) String nom) {
		if (nom == null) {
			nom = "UNKNOWN";
		}
		return "Hola " + nom + ". Estàs executant un projecte Maven.";
	}

}
