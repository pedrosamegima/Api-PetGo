package com.PetGo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.PetGo.entities.Proprietario;


public interface ProprietarioRepository extends JpaRepository <Proprietario, Long>{
	//QUERY METHOD
	List<Proprietario>findByNome(String nome);
	
	//QUERY METHOD
	List<Proprietario>findByCpf(String cpf);
	
	
	@Query("SELECT a FROM Proprietario a WHERE a.cidade = :cidade")
	List<Proprietario> findByCidade(@Param("cidade")String cidade);
	
	@Query("SELECT a FROM Proprietario a WHERE a.logradouro = :logradouro")
	List<Proprietario> findByLogradouro(@Param("logradouro")String logradouro);
}
