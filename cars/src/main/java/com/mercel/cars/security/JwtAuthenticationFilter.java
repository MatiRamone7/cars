package com.mercel.cars.security;

import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/*
 * Métodos de autenticación 
 * Se chequea el username y password de la URL con Spring authentication manager
 * Si el username y password son correctos, se creará un JWT token y lo manda a authorization
 */

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;

		setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		var username = request.getParameter("username");
		var password = request.getParameter("password");
		var authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain, Authentication authentication) {
		var user = ((UserDetails) authentication.getPrincipal());

		var roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

		var signingKey = SecurityConstants.JWT_SECRET.getBytes();

		var token = Jwts.builder().signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
				.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE).setIssuer(SecurityConstants.TOKEN_ISSUER)
				.setAudience(SecurityConstants.TOKEN_AUDIENCE).setSubject(user.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + 864000000)).claim("rol", roles).compact();

		response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
	}
}
