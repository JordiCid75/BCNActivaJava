package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.config;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.jwt.AuthEntryPointJwt;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.jwt.JwtAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	JwtAuthenticationFilter JwtAuthenticationFilter;
	@Autowired
	AuthenticationProvider authProvider;
	@Autowired
	AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http
				 .csrf(AbstractHttpConfigurer::disable)
				 .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
				 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				 .authorizeHttpRequests(authHttp -> authHttp
						 .requestMatchers(
								 new AntPathRequestMatcher("/auth/**"),
								 new AntPathRequestMatcher("/v1/**"),
								 new AntPathRequestMatcher("/views/**"),
								 new AntPathRequestMatcher("/templates/**"),
								 new AntPathRequestMatcher("/static/**"),
								 new AntPathRequestMatcher("/css/**"),
								 new AntPathRequestMatcher("/js/**"),
								 new AntPathRequestMatcher("/images/**"),
								 new AntPathRequestMatcher("/v1/index/**"),
						 new AntPathRequestMatcher("/login/**"))
				 .permitAll().anyRequest().authenticated())
             	.authenticationProvider(authProvider)
                .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
               .formLogin(formLogin -> formLogin.loginPage("/login/frmLogin.html").permitAll())
		;
		http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

		return http.build();
	}
}
