package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.services.ISucursalService;

@Controller
@RequestMapping("/views/sucursal")
public class SucursalsController {

	@Autowired
	private ISucursalService sucursalService;
	@GetMapping("/")
	public String getSucursales(Model model)
	{
		List<SucursalDTO> listadoSucursales = sucursalService.getAllSucursales();
		model.addAttribute("titulo","Lista de Sucursales");
		model.addAttribute("sucursales",listadoSucursales);
		return "/views/sucursal/ListarSucursal";
	}
	
	@GetMapping("/create")
	public String createSucursal(Model model)
	{
		return "/views/sucursal/frmCrearSucursal";
	}
}
