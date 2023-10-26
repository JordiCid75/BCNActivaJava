package TareaS107.N1Exercici2;

public class Treballador {
	String nom;
	String cognom;
	double preuHora;
	
	public double calcularSou(int horasTreballades)
	{
		return horasTreballades * preuHora;
	}

	@Override
	public String toString() {
		return "Treballador [nom=" + nom + ", cognom=" + cognom + ", preuHora=" + preuHora + "]";
	}

}
