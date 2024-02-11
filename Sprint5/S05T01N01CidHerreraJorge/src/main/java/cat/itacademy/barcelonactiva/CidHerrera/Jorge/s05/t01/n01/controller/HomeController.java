package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/", "/home","/index"})
	public String index() {
		return "index";
	}
}
