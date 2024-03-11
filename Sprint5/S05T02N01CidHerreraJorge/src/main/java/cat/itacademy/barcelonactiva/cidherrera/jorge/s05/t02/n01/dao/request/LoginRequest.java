package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	private String username;
	private String password;

}
