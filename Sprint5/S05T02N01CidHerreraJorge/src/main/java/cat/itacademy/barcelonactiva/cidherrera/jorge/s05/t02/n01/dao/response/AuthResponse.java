package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
 private String token;


}
