package TareaS108.N1Exercici1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lista {
	List<String> list = Arrays.asList("pweefuwp",
									"lksjhfsalkjf",
									"pwo",
									"oooffff",
									"xznznxvcnxv");
	
	public List<String> filtrar(){
		List<String> l = new ArrayList<String>();
		list.forEach((s)->{if (s.contains("o")) {l.add(s);}});
		return l;
	}
}