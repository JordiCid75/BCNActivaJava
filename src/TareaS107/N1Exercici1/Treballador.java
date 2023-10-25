package TareaS107.N1Exercici1;

public class Treballador {
	String nom;
	String cognom;
	double preuHora;
	
	public double calcularSou(int horasTreballades)
	{
		return horasTreballades * preuHora;
	}

}
