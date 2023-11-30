package TareaS108.N1Exercici1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {
	List<String> list = Arrays.asList("pweefuwp",
									"lksjhfsalkjf",
									"pwo",
									"oooffff",
									"xznznxvcnxv");
	
	public List<String> filtrar(){
		return list.stream().filter((s)->s.contains("o")).collect(Collectors.toList());
	}
}
