package TareaS107.N1Exercici2;

public class TreballadorPresencial extends Treballador {
	double benzina;

	public TreballadorPresencial(String pnom, String pcognom, double ppreuHora, double pbenzina) {
		super(pnom, pcognom, ppreuHora);
		benzina = pbenzina;
	}

	@Override
	public double calcularSou(int horasTreballades) {

		return super.calcularSou(horasTreballades) + benzina;
	}
	@Override
	public String toString() {
		return "TreballadorPresencial [benzina=" + benzina + ", nom=" + nom + ", cognom=" + cognom + ", preuHora="
				+ preuHora + "]";
	}

}
