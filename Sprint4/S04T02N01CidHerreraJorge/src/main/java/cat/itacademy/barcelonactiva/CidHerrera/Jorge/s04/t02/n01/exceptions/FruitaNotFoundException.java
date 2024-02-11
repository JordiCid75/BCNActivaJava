package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.exceptions;

public class FruitaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FruitaNotFoundException(String msg) {
		super(msg);
	}
}
