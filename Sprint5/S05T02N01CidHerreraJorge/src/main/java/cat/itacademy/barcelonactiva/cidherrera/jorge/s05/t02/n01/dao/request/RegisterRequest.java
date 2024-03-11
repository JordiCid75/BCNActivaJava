package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;


}
