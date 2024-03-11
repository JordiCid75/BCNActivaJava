package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Service
public class JwtServiceImpl implements IJwtService {

	private static final String SECRT_KEY =  "12345678901234567890123456789012345678901234567890";
	@Override
	public String getToken(UserDetails user) {
		return getToken(new HashMap<>(), user);
	}

	private String getToken(Map<String, Object> extraClaims, UserDetails user) {
		return Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();

	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRT_KEY);

		return Keys.hmacShaKeyFor(keyBytes);
	}

	@Override
	public String getUserNameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	@Override
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = getUserNameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Claims getAllClaims(String token)
	{
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver )
	{
		final Claims claims=getAllClaims(token);
		return claimsResolver.apply(claims);
	}
	private Date getExpiration(String token)
	{
		return getClaim(token, Claims::getExpiration);
	}
	private boolean isTokenExpired(String token)
	{
		return getExpiration(token).before(new Date());
	}

}
