package TareaS108.N1Exercici6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List <String> l = Arrays.asList("12345",
				"defdsfhasdkh",
				"789tttff",
				"abctststr",
				"456",
				"ghi");
		l.sort(Comparator.comparing(String::length));
		l.forEach(System.out::println);
	}

}
