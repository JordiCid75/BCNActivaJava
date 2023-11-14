package TareaS107.N1Exercici2;

public class Treballador {
	String nom;
	String cognom;
	double preuHora;
	
	public Treballador(String pnom, String pcognom, double ppreuHora) {
		nom = pnom;
		cognom = pcognom;
		preuHora = ppreuHora;
	}

	public double calcularSou(int horasTreballades)
	{
		return horasTreballades * preuHora;
	}

	@Override
	public String toString() {
		return "Treballador [nom=" + nom + ", cognom=" + cognom + ", preuHora=" + preuHora + "]";
	}

}
