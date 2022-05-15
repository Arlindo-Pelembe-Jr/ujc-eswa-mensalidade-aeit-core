package com.ujc.eswa.mensalidade.aeit.security.filter;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujc.eswa.mensalidade.aeit.dto.AuthResponseDTO;
import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
import com.ujc.eswa.mensalidade.aeit.security.security.JwtUtil;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				request.getParameter("username"), request.getParameter("password"));
		return authenticationManager.authenticate(authenticationToken);
//		return super.attemptAuthentication(request, response);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
	Utilizador principal = (Utilizador)	authResult.getPrincipal();
		String access_token = JWT.create().withSubject(principal.getUserName())
				.withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 72 * 1000))
				.withIssuer(request.getRequestURI().toString()).withClaim("perfilUtilizador", principal.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(JwtUtil.getAlgorithm());
		
		AuthResponseDTO authResponseDTO = new AuthResponseDTO(principal.getNome(), 
				principal.getUsername(), access_token,principal.getId());
		authResponseDTO.setPerfilUtilizadors(principal.getPerfiSet());

		response.setContentType(APPLICATION_JSON_VALUE);

		new ObjectMapper().writeValue(response.getOutputStream(), authResponseDTO);
//		super.successfulAuthentication(request, response, chain, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Map<String, Object> data = new HashMap<>();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		data.put("timestamp", sdf.format(Calendar.getInstance().getTime()));

		if (failed.getCause() instanceof SecurityException) {
			data.put("message", failed.getMessage());
			data.put("details", "");
		} else {
			data.put("message", "Username ou senha invalidos");
			data.put("details", failed.getMessage());
		}

		response.getOutputStream().println(objectMapper.writeValueAsString(data));
//		super.unsuccessfulAuthentication(request, response, failed);
	}
	
	
}
