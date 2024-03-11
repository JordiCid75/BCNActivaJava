package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request.LoginRequest;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.request.RegisterRequest;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.dao.response.AuthResponse;

public interface IAuthService {
	AuthResponse login(LoginRequest request);
	AuthResponse register(RegisterRequest request);

}
