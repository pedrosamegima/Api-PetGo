package com.PetGo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.PetGo.entities.Veterinario;

public interface VeterinarioRepository extends JpaRepository <Veterinario, Long>{
		//QUERY METHOD
		List<Veterinario>findByNome(String nome);
		
		//QUERY METHOD
		List<Veterinario>findByCrmv(String crmv);
		
		
		@Query("SELECT a FROM Veterinario a WHERE a.logradouro = :logradouro")
		List<Veterinario> findByLogradouro(@Param("logradouro")String logradouro);
		
		@Query("SELECT a FROM Pet a WHERE a.cidade = :cidade")
		List<Veterinario> findByCidade(@Param("Cidade")String cidade);
}
