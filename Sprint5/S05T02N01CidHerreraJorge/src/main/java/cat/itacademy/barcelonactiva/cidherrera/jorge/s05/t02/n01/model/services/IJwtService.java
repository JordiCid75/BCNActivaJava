package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
	public String getToken(UserDetails user);

	public String getUserNameFromToken(String token);

	public boolean isTokenValid(String token, UserDetails userDetails);
}
