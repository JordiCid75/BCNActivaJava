package TareaS107.N1Exercici2;

public class TreballadorOnline extends Treballador {
	final double TARIFA_INTERNET = 45.6;

	@Override
	public double calcularSou(int horesTreballades) {
		return super.calcularSou(horesTreballades) + TARIFA_INTERNET;
	}

	@Override
	public String toString() {
		return "TreballadorOnline [TARIFA_INTERNET=" + TARIFA_INTERNET + ", nom=" + nom + ", cognom=" + cognom
				+ ", preuHora=" + preuHora + "]";
	}

	public void pruebaNoDeprecated(int horas) {
		System.out.println("Treballador Online método prueba." + horas);
	}

	/**
	 * @deprecated uso de pruebaDepreciated está discontinuado, usar prueba en su
	 *             lugar.
	 */
	@Deprecated
	public void pruebaDeprecated(int horas) {
		System.out.println("Treballador Online método prueba_deprecated." + horas);
	}

}
