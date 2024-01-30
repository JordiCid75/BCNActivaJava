package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.domain;

import jakarta.persistence.*;
// import jakarta.persistence.*; // for Spring Boot 3

@Entity
@Table(name = "fruites")
public class Fruita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "quantitatQuilos")
	private int quantitatQuilos;

	public Fruita() {
		// TODO Auto-generated constructor stub
	}

	public Fruita(String nom, int quantitat) {
		this.nom = nom;
		this.quantitatQuilos = quantitat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
	}

	
}
