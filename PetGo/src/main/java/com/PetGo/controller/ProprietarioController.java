package com.PetGo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PetGo.entities.Proprietario;
import com.PetGo.service.ProprietarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/proprietario")
public class ProprietarioController {
	private final ProprietarioService proprietarioService;
	@Autowired
	public ProprietarioController(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza proprietario por ID")
	public ResponseEntity<Proprietario> getProprietarioById(@PathVariable Long id) {
		Proprietario proprietario = proprietarioService.getProprietarioById(id);
		if (proprietario != null) {
			return ResponseEntity.ok(proprietario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os proprietario")
	public ResponseEntity<List<Proprietario>> getAllProprietario() {
		List<Proprietario> proprietario = proprietarioService.getAllProprietario();
		return ResponseEntity.ok(proprietario);
	}
	//@Query
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Aprensenta o nome dos proprietario")
	public ResponseEntity<List<Proprietario>> getProdutosPorNome(@PathVariable String nome){
		List<Proprietario> proprietarios = proprietarioService.getProprietariosPorNome(nome);
		return ResponseEntity.ok(proprietarios);
	}
	//@Query
	@GetMapping("/cpf/{cpf}")
	@Operation(summary = "Aprensenta o cpf dos proprietario")
	public List<Proprietario> findProprietariosPorCpf(@PathVariable String cpf){
		return proprietarioService.findByCpf(cpf);
	}
	
	//@Query
		@GetMapping("/cidade/{cidade}")
		@Operation(summary = "Aprensenta a cidade dos proprietario")
		public List<Proprietario> findProprietariosPorCidade(@PathVariable String cidade){
			return proprietarioService.findByCidade(cidade);
		}
		//@Query
		@GetMapping("/logradouro/{logradouro}")
		@Operation(summary = "Aprensenta o logradouro dos proprietario")
		public List<Proprietario> findProprietariosPorLogradouro(@PathVariable String logradouro){
			return proprietarioService.findByLogradouro(logradouro);
		}

	@PostMapping("/")
	@Operation(summary = "Cadastra um proprietario")
	public ResponseEntity<Proprietario> criarProprietario(@RequestBody Proprietario proprietario) {
		Proprietario criarProprietario = proprietarioService.salvarProprietario(proprietario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarProprietario);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o proprietario")
	public ResponseEntity<Proprietario> updateProprietario(@PathVariable Long id,@RequestBody Proprietario proprietario) {
		Proprietario updatedProprietario = proprietarioService.updateProprietario(id, proprietario);
		if (updatedProprietario != null) {
			return ResponseEntity.ok(updatedProprietario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um proprietario")
	public ResponseEntity<String> deleteProprietario(@PathVariable Long id) {
		boolean deleted = proprietarioService.deleteProprietario(id);
		if (deleted) {
			return ResponseEntity.ok().body("O proprietario foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

