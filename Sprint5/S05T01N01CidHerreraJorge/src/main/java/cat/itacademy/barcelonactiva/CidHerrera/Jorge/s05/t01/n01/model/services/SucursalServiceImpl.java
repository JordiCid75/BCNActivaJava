package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService {

	@Autowired
	SucursalRepository sucursalRepository;

	@Override
	public List<SucursalDTO> getAllSucursales() {
		try {
			List<SucursalDTO> sucursals = new ArrayList<SucursalDTO>();

			sucursalRepository.findAll().forEach((s)->sucursals.add(new SucursalDTO(s)));

			return sucursals;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public SucursalDTO getSucursalById(int id) {
		Optional<Sucursal> sucursalData = sucursalRepository.findById(id);

		if (sucursalData.isPresent()) {
			return new SucursalDTO(sucursalData.get());
		} else {
			return null;
		}
	}

	@Override
	public void deleteSucursalById(int id) {
		sucursalRepository.deleteById(id);
	}

	@Override
	public SucursalDTO createSucursal(SucursalDTO sucursal) {
		try {
			Sucursal _sucursal = sucursalRepository.save(new Sucursal(sucursal.getSucursal().getPk_sucursalID(),
					sucursal.getSucursal().getNameSucursal(), sucursal.getSucursal().getPaisSucursal()));
			return new SucursalDTO(_sucursal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public SucursalDTO updateSucursal(SucursalDTO sucursal) {
		Optional<Sucursal> sucursalData = sucursalRepository.findById(sucursal.getSucursal().getPk_sucursalID());

		if (sucursalData.isPresent()) {
			Sucursal _sucursal = sucursalData.get();
			_sucursal.setNameSucursal(sucursal.getSucursal().getNameSucursal());
			_sucursal.setPaisSucursal(sucursal.getSucursal().getPaisSucursal());
			return new SucursalDTO(sucursalRepository.save(_sucursal));
		} else {
			return null;
		}
	}

}
