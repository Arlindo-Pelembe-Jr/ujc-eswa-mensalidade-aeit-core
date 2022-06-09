package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.dto.SignupRequestDTO;
import com.ujc.eswa.mensalidade.aeit.exception.ResourceNotFoundException;
import com.ujc.eswa.mensalidade.aeit.model.Curso;
import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.model.Funcionario;
import com.ujc.eswa.mensalidade.aeit.model.Pagamento;
import com.ujc.eswa.mensalidade.aeit.model.Perfil;
import com.ujc.eswa.mensalidade.aeit.model.PerfilUtilizador;
import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
import com.ujc.eswa.mensalidade.aeit.repository.EstudanteRepository;
import com.ujc.eswa.mensalidade.aeit.repository.FuncionarioRepository;
import com.ujc.eswa.mensalidade.aeit.repository.PagamentoRepository;
import com.ujc.eswa.mensalidade.aeit.repository.PerfilUtilizadorRepository;
import com.ujc.eswa.mensalidade.aeit.repository.UtilizadorRepository;
import com.ujc.eswa.mensalidade.aeit.service.UtilizadorService;

@RestController
@RequestMapping(value = "ujc-mensalidade/api/v1/utilizadores")
@CrossOrigin
public class UtilizadorController {
	@Autowired
	private UtilizadorRepository utilizadorRepository;

	@Autowired
	private EstudanteRepository estudanteRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private PerfilUtilizadorRepository perfilUtilizadorRepository;

	@Autowired
	private UtilizadorService utilizadorService;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@GetMapping
	public ResponseEntity<List<Utilizador>> getAllUsers() {
//		 userRepository.findAll();
		return ResponseEntity.ok().body(utilizadorRepository.findAll());

	}

	@GetMapping("/{userName}/{senha}")
	public ResponseEntity<Utilizador> login(@PathVariable String userName, @PathVariable String senha) {
		Utilizador user = utilizadorRepository.findByUserNameAndSenhaUtilizador(userName, senha);

		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<Utilizador> authUser(@PathVariable String email, @PathVariable String senha) {
		Utilizador userUtilizador = utilizadorRepository.findByEmailAndSenhaUtilizador(email, senha);
		return ResponseEntity.ok().body(userUtilizador);
	}

	@GetMapping("/{id}/{senha}/search")
	public ResponseEntity<Utilizador> authetication(@PathVariable Long id, @PathVariable String senha)
			throws ResourceNotFoundException {
//		Utilizador user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Utilizador nao encontrado"+id));
//		userRepository.findBySenhaUtilizador(senha);
		Utilizador user = utilizadorRepository.findByIdAndSenhaUtilizador(id, senha);
//		if(user.getSenha() == senha) {
		return ResponseEntity.ok().body(user);
//
//		}
//		return ResponseEntity.notFound().build();
	}

//	@PostMapping
//	public Utilizador sigin(@RequestBody Utilizador utilizador) {
//		System.out.println("To create current user: " + utilizador.getUserName());
//		utilizador.setSenha(utilizadorService.passEncoder(utilizador.getSenha()));
//		utilizador.setTextPassword(utilizador.getSenha());
//		return utilizadorRepository.save(utilizador);
//	}

	@PostMapping("/api/v1/auth/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequestDTO requestDTO) throws Exception {
		Utilizador user = utilizadorService.registerUser(requestDTO);
		return ResponseEntity.ok().body(user.getConfirmationToken()); // TODO: review return type. Consider returning
																		// the URI
	}

	@PostMapping("/{id}")
	public Utilizador updateUser(@RequestBody Utilizador utilizador, @PathVariable Long id)
			throws ResourceNotFoundException {
		System.out.println("To update current user: " + utilizador.getUserName());
		Utilizador updateUtilizador = utilizadorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Utilizador nao encontrado" + id));
		utilizador.setId(updateUtilizador.getId());
		return utilizadorRepository.save(utilizador);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/role")
	public ResponseEntity<Map<String, Object>> siginBasedRole(@RequestBody Map<String, Object> userRole)
			throws Exception {

		System.out.println("userRole RequestBody: " + userRole);
		List<Map<String, Object>> dataResponse = new ArrayList<>();
//		System.out.println("To create current user: "+utilizador.getUserName());
		Map<String, Object> userMap = (Map<String, Object>) userRole.get("utilizador");

		System.out.println("user: " + userMap);

		SignupRequestDTO createdUser = new SignupRequestDTO();
		createdUser.setNome(userMap.get("nome").toString());
		createdUser.setSenha(userMap.get("senha").toString());
		createdUser.setEmail(userMap.get("email").toString());
		Map<String, Object> perfilUitliMap = (Map<String, Object>) userRole.get("perfilUtilizador");

		System.out.println("perfilUtilizador: " + perfilUitliMap);
		PerfilUtilizador perfilUtilizador = new PerfilUtilizador();
		Perfil perfil = Perfil.valueOf(perfilUitliMap.get("perfil").toString());
		perfilUtilizador.setPerfil(perfil);
		createdUser.setPerfilUtilizador(perfilUtilizador);
//		perfilUtilizador.setUtilizador(createdUser);
//			createdUser=	utilizadorRepository.save(createdUser);

		System.out.println(createdUser);
		Utilizador newUSer = new Utilizador();
		newUSer = utilizadorService.registerUser(createdUser);
		System.out.println("created User " + newUSer);
		Estudante createdStudent = new Estudante();
		Funcionario createdFuncionario = new Funcionario();

		switch (perfilUitliMap.get("perfil").toString()) {
		case "ADMIN":

			break;
		case "ESTUDANTE":
			Map<String, Object> studentMap = (Map<String, Object>) userRole.get("estudante");
			System.out.println("studentMap: " + studentMap);

			createdStudent.setNome(studentMap.get("nome").toString());
			createdStudent.setContacto(Long.parseLong(studentMap.get("contacto").toString()));
			createdStudent.setData_nascimento(studentMap.get("dataNascimento").toString());
			createdStudent.setData_ingresso(studentMap.get("dataIngresso").toString());
			createdStudent.setNacionalidade(studentMap.get("nacionalidade").toString());
			createdStudent.setEmail(studentMap.get("email").toString());
			createdStudent.setCod_estudante(estudanteRepository.findMaxCodEstudante() + 1);
			Map<String, Object> cursoMap = (Map<String, Object>) studentMap.get("curso");

			createdStudent.setCurso(new Curso(Long.parseLong(cursoMap.get("cursoCodigo").toString())));
			createdStudent.setUtilizador(newUSer);
			createdStudent = estudanteRepository.save(createdStudent);
			System.out.println("created student " + createdStudent);
			for (int i = 0; i < 5; i++) {
					Pagamento pagamento = new Pagamento();
					pagamento.setEstudante(createdStudent);
					pagamento.setStatus((long) 1);
					pagamentoRepository.save(pagamento);
			}
			break;
		case "FUNCIONARIO":
			Map<String, Object> funcionarioMap = (Map<String, Object>) userRole.get("funcionario");
			System.out.println("studentMap: " + funcionarioMap);

			createdFuncionario.setNome(funcionarioMap.get("nome").toString());
			createdFuncionario.setContacto(Long.parseLong(funcionarioMap.get("contacto").toString()));
			createdFuncionario.setDataNascimento(funcionarioMap.get("dataNascimento").toString());
			createdFuncionario.setNacionalidade(funcionarioMap.get("nacionalidade").toString());
			createdFuncionario.setEmail(funcionarioMap.get("email").toString());
			createdFuncionario.setUtilizador(newUSer);
			createdFuncionario = funcionarioRepository.save(createdFuncionario);
			break;
		default:
			break;
		}

//		Map<String, Object> perfilUitliMap = (Map<String, Object>) userRole.get("perfilUtilizador");

//		System.out.println("perfilUtilizador: " + perfilUitliMap);
//		PerfilUtilizador perfilUtilizador = new PerfilUtilizador();
//		Perfil perfil = Perfil.valueOf(perfilUitliMap.get("perfil").toString());
//		perfilUtilizador.setPerfil(perfil);
//		perfilUtilizador.setUtilizador(createdUser);
//		perfilUtilizador= perfilUtilizadorRepository.save(perfilUtilizador);
		Map<String, Object> dataObjectMap = new HashMap<>();

		dataObjectMap.put("utilizador", newUSer);
		dataObjectMap.put("estudante", createdStudent);
		dataObjectMap.put("funcionario", createdFuncionario);

//		dataObjectMap.put("perfilUtilizador", perfilUtilizador);
		dataResponse.add(dataObjectMap);

//		return utilizadorRepository.save(utilizador);
		return ResponseEntity.ok().body(dataObjectMap);
	}
}
