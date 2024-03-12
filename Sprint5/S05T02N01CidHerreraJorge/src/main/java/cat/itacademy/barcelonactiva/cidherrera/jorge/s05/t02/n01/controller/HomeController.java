package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/v1", "/home","/index"})
	public String index() {
		return "index";
	}
	
}
