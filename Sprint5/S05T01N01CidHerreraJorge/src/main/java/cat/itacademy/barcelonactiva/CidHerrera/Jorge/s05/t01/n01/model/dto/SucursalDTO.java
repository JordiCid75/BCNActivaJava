package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.dto;

import java.util.List;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.domain.Sucursal;
import jakarta.persistence.*;

public class SucursalDTO {
	private List<String> paisos;

	private final String NO_UE = "No UE";
	private final String UE = "UE";
	public Sucursal sucursal;
	private String tipusSucursal;

	public SucursalDTO(Sucursal sucursal) {
		this.sucursal = sucursal;
		this.paisos = List.of("Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia",
				"Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
				"Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia",
				"Lituania", "Portugal", "Rumanía");
		//this.setTipusSucursal();
	}

	public SucursalDTO() {
		this.paisos = List.of("Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia",
				"Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
				"Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia",
				"Lituania", "Portugal", "Rumanía");
	
	}
	
	public String getTipusSucursal() {
		if (this.sucursal != null) {
			if (this.paisos.contains(sucursal.getPaisSucursal())) {
				this.tipusSucursal = UE;
			} else {
				this.tipusSucursal = NO_UE;
			}
		}
		return tipusSucursal;
	}

	public void setTipusSucursal() {
		if (this.sucursal != null) {
			if (this.paisos.contains(sucursal.getPaisSucursal())) {
				this.tipusSucursal = UE;
			} else {
				this.tipusSucursal = NO_UE;
			}
		}
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}
