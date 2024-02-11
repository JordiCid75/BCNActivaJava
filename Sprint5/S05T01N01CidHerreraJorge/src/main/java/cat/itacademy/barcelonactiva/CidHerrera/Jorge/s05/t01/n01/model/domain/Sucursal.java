package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Sucursals")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_sucursalID;
	@Column(name = "name")
	private String nameSucursal;
	@Column(name = "pais")
	private String paisSucursal;
	
	public Sucursal(int id, String name, String pais) {
		pk_sucursalID = id;
		nameSucursal = name;
		paisSucursal = pais;
	}
	public Sucursal() {
	}

	public int getPk_sucursalID() {
		return pk_sucursalID;
	}

	public void setPk_sucursalID(int pk_sucursalID) {
		this.pk_sucursalID = pk_sucursalID;
	}

	public String getNameSucursal() {
		return nameSucursal;
	}

	public void setNameSucursal(String nameSucursal) {
		this.nameSucursal = nameSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	@Override
	public String toString() {
		return "Sucursal [pk_sucursalID=" + pk_sucursalID + ", nameSucursal=" + nameSucursal + ", paisSucursal="
				+ paisSucursal + "]";
	}

}
