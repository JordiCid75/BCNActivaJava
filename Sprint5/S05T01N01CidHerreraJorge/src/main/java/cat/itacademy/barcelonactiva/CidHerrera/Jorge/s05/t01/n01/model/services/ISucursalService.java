package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.dto.SucursalDTO;

public interface ISucursalService {

	public List<SucursalDTO> getAllSucursales();
	public SucursalDTO getSucursalById(int id);
	public void deleteSucursalById(int id);
	public SucursalDTO createSucursal(SucursalDTO sucursal);
	public SucursalDTO updateSucursal(SucursalDTO sucursal);
	
}
