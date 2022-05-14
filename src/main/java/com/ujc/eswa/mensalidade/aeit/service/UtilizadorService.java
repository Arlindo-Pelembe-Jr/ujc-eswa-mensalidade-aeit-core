package com.ujc.eswa.mensalidade.aeit.service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ujc.eswa.mensalidade.aeit.dto.SignupRequestDTO;
import com.ujc.eswa.mensalidade.aeit.model.PerfilUtilizador;
import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
import com.ujc.eswa.mensalidade.aeit.repository.UtilizadorRepository;

@Service
@Transactional
public class UtilizadorService implements UserDetailsService{
	
	private final UtilizadorRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private Environment env;
 public	UtilizadorService(UtilizadorRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String uptimeStr = env.getProperty("system.uptime");

		if (uptimeStr != null) {

			String[] uptime = uptimeStr.split("-");

			Date initialDate = Calendar.getInstance().getTime(), finalDate = Calendar.getInstance().getTime();

			initialDate.setHours(Integer.parseInt(uptime[0].split(":")[0]));
			initialDate.setMinutes(Integer.parseInt(uptime[0].split(":")[1]));
			finalDate.setHours(Integer.parseInt(uptime[1].split(":")[0]));
			finalDate.setMinutes(Integer.parseInt(uptime[1].split(":")[1]));

			Utilizador user = userRepository.findByEmailAndEnabledUtilizador(email);

//			if (user != null && user.get != null) {
//				Date currentDate = Calendar.getInstance().getTime();
//				if (!(currentDate.after(initialDate) && currentDate.before(finalDate))) {
//					throw new SecurityException(
//							"O sistema nao se encontra disponivel de momento. O periodo de funcionamento e das "
//									+ uptime[0] + " as " + uptime[1]);
//				}
//			}
//		}
		}
		Utilizador userUtilizador = this.userRepository.findByEmailAndEnabledUtilizador(email);
		System.out.println(userUtilizador);
		return userUtilizador;
	
	}
	
	public Utilizador registerUser(SignupRequestDTO request) throws Exception {

		if (userRepository.existsByEmail(request.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe o vendedor com nome indicado");
		}

		Utilizador user = new Utilizador();
		user.setNome(request.getNome());
		user.setSenha(passwordEncoder.encode(request.getSenha()));
		user.setUserName(request.getNome());
		user.setEmail(request.getEmail());
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		String token = UUID.randomUUID().toString();
		user.setConfirmationToken(token);
		user.setTextPassword(request.getSenha());
		user.addRole(new PerfilUtilizador(request.getPerfilUtilizador().getPerfil()));
		userRepository.save(user);
		return user;
	}
	public String passEncoder(String pass) {
		String encodedPass = passwordEncoder.encode((pass));
		return encodedPass;
	}
}
