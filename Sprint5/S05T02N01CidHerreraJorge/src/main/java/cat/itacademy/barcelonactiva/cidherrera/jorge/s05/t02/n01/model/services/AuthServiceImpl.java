package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request.LoginRequest;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request.RegisterRequest;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.response.AuthResponse;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Role;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.User;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	IJwtService jwtService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);
		return AuthResponse.builder().token(token).build();
	}

	@Override
	public AuthResponse register(RegisterRequest request) {
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.role(Role.USER)
				.build();
		userRepository.save(user);
		return AuthResponse.builder().token(jwtService.getToken(user)).build();
	}

}
