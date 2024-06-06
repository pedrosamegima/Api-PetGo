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

import com.PetGo.entities.Veterinario;
import com.PetGo.service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/veterinario")
public class VeterinarioController {
	private final VeterinarioService veterinarioService;
	@Autowired
	public VeterinarioController(VeterinarioService veterinarioService) {
		this.veterinarioService = veterinarioService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza veterinario por ID")
	public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable Long id) {
		Veterinario veterinario = veterinarioService.getVeterinarioById(id);
		if (veterinario != null) {
			return ResponseEntity.ok(veterinario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os veterinario")
	public ResponseEntity<List<Veterinario>> getAllVeterinario() {
		List<Veterinario> veterinario = veterinarioService.getAllVeterinario();
		return ResponseEntity.ok(veterinario);
	}
	//@Query
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Aprensenta o nome dos veterinarios")
	public ResponseEntity<List<Veterinario>> getVeterinariosPorNome(@PathVariable String nome){
		List<Veterinario> veterinarios = veterinarioService.getVeterinarioPorNome(nome);
		return ResponseEntity.ok(veterinarios);
	}
	//@Query
	@GetMapping("/crmv/{crmv}")
	@Operation(summary = "Aprensenta o crmv dos veterinarios")
	public List<Veterinario> findVeterinariosPorCrmv(@PathVariable String crmv){
		return veterinarioService.findByCrmv(crmv);
	}
	//@Query
	@GetMapping("/logradouro/{logradouro}")
	@Operation(summary = "Aprensenta o logradouro dos veterinarios")
	public List<Veterinario> findVeterinariosPorLogradouro(@PathVariable String logradouro){
		return veterinarioService.findByLogradouro(logradouro);
	}
	//@Query
	@GetMapping("/cidade/{cidade}")
	@Operation(summary = "Aprensenta a cidade dos veterinarios")
	public List<Veterinario> findVeterinariosPorCidade(@PathVariable String cidade){
		return veterinarioService.findByLogradouro(cidade);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra um veterinario")
	public ResponseEntity<Veterinario> criarVeterinario(@RequestBody Veterinario veterinario) {
		Veterinario criarVeterinario = veterinarioService.salvarVeterinario(veterinario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarVeterinario);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o veterinario")
	public ResponseEntity<Veterinario> updateVeterinario(@PathVariable Long id,@RequestBody Veterinario veterinario) {
		Veterinario updatedVeterinario = veterinarioService.updateVeterinario(id, veterinario);
		if (updatedVeterinario != null) {
			return ResponseEntity.ok(updatedVeterinario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um veterinario")
	public ResponseEntity<String> deleteVeterinario(@PathVariable Long id) {
		boolean deleted = veterinarioService.deleteVeterinario(id);
		if (deleted) {
			return ResponseEntity.ok().body("O veterinario foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
