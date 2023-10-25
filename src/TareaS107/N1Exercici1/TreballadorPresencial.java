package TareaS107.N1Exercici1;

public class TreballadorPresencial extends Treballador {
	double benzina;
	@Override
	public double calcularSou(int horasTreballades) {

		return super.calcularSou(horasTreballades) + benzina;
	}

}
