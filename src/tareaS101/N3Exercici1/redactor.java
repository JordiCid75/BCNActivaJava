package tareaS101.N3Exercici1;

import java.util.ArrayList;

public class redactor {
	public String nom;
	public String DNI;
	public static final float sou = 1500;
	public ArrayList<noticia> noticies = new ArrayList<noticia>();

	public redactor(String nom, String dni) {
		this.nom = nom;
		this.DNI = dni;
	}

	public void afegirNoticia(noticia noticia) {
		this.noticies.add(noticia);
	}

	public void eliminarNoticia(noticia noticia) {
		this.noticies.remove(noticia);
	}

	public noticia buscarNoticia(String titular) {
		for (noticia n : noticies) {
			if (n.titular.toLowerCase().equals(titular)) {
				return n;
			}
		}
		return null;
	}

}
