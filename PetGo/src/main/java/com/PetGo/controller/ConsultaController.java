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

import com.PetGo.entities.Consulta;
import com.PetGo.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	private final ConsultaService consultaService;
	@Autowired
	public ConsultaController(ConsultaService consultaService) {
		this.consultaService = consultaService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza consulta por ID")
	public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
		Consulta consulta = consultaService.getConsultaById(id);
		if (consulta != null) {
			return ResponseEntity.ok(consulta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todas as consultas")
	public ResponseEntity<List<Consulta>> getAllConsulta() {
		List<Consulta> consulta = consultaService.getAllConsulta();
		return ResponseEntity.ok(consulta);
	}
	//@Query
	@GetMapping("/data/{data}")
	@Operation(summary = "Aprensenta a data da consulta")
	public ResponseEntity<List<Consulta>> getConsultaPorData(@PathVariable String data){
		List<Consulta> consultas = consultaService.getConsultaPorData(data);
		return ResponseEntity.ok(consultas);
	}
	//@Query
	@GetMapping("/hora/{hora}")
	@Operation(summary = "Aprensenta a hora consulta")
	public List<Consulta> findConsultasPorHora(@PathVariable String hora){
		return consultaService.findByHora(hora);
	}

	//@Query
	@GetMapping("/descricao/{descricao}")
	@Operation(summary = "Aprensenta a descricao consulta")
	public List<Consulta> findPorDescricao(@PathVariable String descricao){
		return consultaService.findByDescricao(descricao);
	}


	@PostMapping("/")
	@Operation(summary = "Cadastra uma consulta")
	public ResponseEntity<Consulta> criarConsulta(@RequestBody Consulta consulta) {
		Consulta criarConsulta = consultaService.salvarConsulta(consulta);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarConsulta);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera a consulta")
	public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id,@RequestBody Consulta consulta) {
		Consulta updatedConsulta = consultaService.updateConsulta(id, consulta);
		if (updatedConsulta != null) {
			return ResponseEntity.ok(updatedConsulta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma consulta")
	public ResponseEntity<String> deleteConsulta(@PathVariable Long id) {
		boolean deleted = consultaService.deleteConsulta(id);
		if (deleted) {
			return ResponseEntity.ok().body("A consulta foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
