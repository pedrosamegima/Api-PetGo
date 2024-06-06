package com.PetGo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PetGo.entities.Tipo;
import com.PetGo.service.TipoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/tipo")
public class TipoController {
	private final TipoService tipoService;
	@Autowired
	public TipoController(TipoService tipoService) {
		this.tipoService = tipoService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza o tipo do animal por ID")
	public ResponseEntity<Tipo> getTipoById(@PathVariable Long id) {
		Tipo tipo = tipoService.getTipoById(id);
		if (tipo != null) {
			return ResponseEntity.ok(tipo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os tipos de animais")
	public ResponseEntity<List<Tipo>> getAllTipo() {
		List<Tipo> tipo = tipoService.getAllTipo();
		return ResponseEntity.ok(tipo);
	}

	@PostMapping("/")
	@Operation(summary = "Cadastra os tipos de animais ")
	public ResponseEntity<Tipo> criarTipo(@RequestBody Tipo tipo) {
		Tipo criarTipo = tipoService.salvarTipo(tipo);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarTipo);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o tipo do animal")
	public ResponseEntity<Tipo> updateTipo(@PathVariable Long id,@RequestBody Tipo tipo) {
		Tipo updatedTipo = tipoService.updateTipo(id, tipo);
		if (updatedTipo != null) {
			return ResponseEntity.ok(updatedTipo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma tipo de animal")
	public ResponseEntity<String> deleteTipo(@PathVariable Long id) {
		boolean deleted = tipoService.deleteTipo(id);
		if (deleted) {
			return ResponseEntity.ok().body("O tipo do animal foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

