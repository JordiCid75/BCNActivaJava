package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request.LoginRequest;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request.RegisterRequest;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.response.AuthResponse;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IAuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private IAuthService authService;
	@PostMapping(value = "login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

		return ResponseEntity.ok(authService.login(request));
	}

	@PostMapping(value="register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

		return ResponseEntity.ok(authService.register(request));
	}
}
