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

import com.PetGo.entities.Pet;
import com.PetGo.service.PetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pet")
public class PetController {
	private final PetService petService;
	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza pet por ID")
	public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
		Pet pet = petService.getPetById(id);
		if (pet != null) {
			return ResponseEntity.ok(pet);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os pet")
	public ResponseEntity<List<Pet>> getAllPet() {
		List<Pet> pet = petService.getAllPet();
		return ResponseEntity.ok(pet);
	}
	//@Query
	@GetMapping("/nome/{nome}")
	@Operation(summary = "Aprensenta o nome dos pets")
	public ResponseEntity<List<Pet>> getPetPorNome(@PathVariable String nome){
		List<Pet> pets = petService.getPetPorNome(nome);
		return ResponseEntity.ok(pets);
	}
	//@Query
	@GetMapping("/raca/{raca}")
	@Operation(summary = "Aprensenta o raca dos pets")
	public List<Pet> findPetsPorRaca(@PathVariable String raca){
		return petService.findByRaca(raca);
	}
	//@Query
	@GetMapping("/dataNasc/{dataNasc}")
	@Operation(summary = "Aprensenta a data de nascimento dos pets")
	public List<Pet> findPetsPorDataNasc(@PathVariable String dataNasc){
		return petService.findByDataNasc(dataNasc);
	}
	
	@PostMapping("/")
	@Operation(summary = "Cadastra um pet")
	public ResponseEntity<Pet> criarPet(@RequestBody Pet pet) {
		Pet criarPet = petService.salvarPet(pet);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPet);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o pet")
	public ResponseEntity<Pet> updatePet(@PathVariable Long id,@RequestBody Pet pet) {
		Pet updatedPet = petService.updatePet(id, pet);
		if (updatedPet != null) {
			return ResponseEntity.ok(updatedPet);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um pet")
	public ResponseEntity<String> deletePet(@PathVariable Long id) {
		boolean deleted = petService.deletePet(id);
		if (deleted) {
			return ResponseEntity.ok().body("O pet foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}


