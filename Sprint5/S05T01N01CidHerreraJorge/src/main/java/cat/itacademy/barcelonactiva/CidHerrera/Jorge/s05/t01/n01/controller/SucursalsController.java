package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.services.ISucursalService;

@Controller
@RequestMapping({"/views/sucursal","/sucursal"})
public class SucursalsController {

	@Autowired
	private ISucursalService sucursalService;
	@GetMapping({"/","/getAll"})
	public String getSucursales(Model model)
	{
		List<SucursalDTO> listadoSucursales = sucursalService.getAllSucursales();
		model.addAttribute("titulo","Lista de Sucursales");
		model.addAttribute("sucursales",listadoSucursales);
		return "/views/sucursal/ListarSucursal";
	}
	
	@GetMapping({"/create","/add"})
	public String createSucursal(Model model)
	{
		SucursalDTO sucursal = new SucursalDTO(new Sucursal());
		model.addAttribute("sucursalDTO", sucursal);
		
		return "/views/sucursal/frmCrearSucursal";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute SucursalDTO sucursal) {
		sucursalService.createSucursal(sucursal);
		
		return "redirect:/views/sucursal/";
	}
	@GetMapping({"/edit/{id}","/update/{id}","/getOne/{id}"})
	public String editSucursal(@PathVariable("id") int idSucursal, Model model)
	{
		SucursalDTO sucursal = sucursalService.getSucursalById(idSucursal);
		model.addAttribute("sucursalDTO", sucursal);
		
		return "/views/sucursal/frmCrearSucursal";
	}
	@GetMapping("/delete/{id}")
	public String deleteSucursal(@PathVariable("id") int idSucursal, Model model)
	{
		sucursalService.deleteSucursalById(idSucursal);
		
		return "redirect:/views/sucursal/";
	}

}
