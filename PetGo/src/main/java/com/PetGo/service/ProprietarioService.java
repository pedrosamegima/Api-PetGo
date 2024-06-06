package com.PetGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetGo.entities.Proprietario;
import com.PetGo.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	private final ProprietarioRepository proprietarioRepository;

	@Autowired
	public ProprietarioService(ProprietarioRepository proprietarioRepository) {
		this.proprietarioRepository = proprietarioRepository;
	}

	public List<Proprietario> getAllProprietario() {
		return proprietarioRepository.findAll();
	}

	public Proprietario getProprietarioById(Long id) {
		Optional<Proprietario> Proprietario = proprietarioRepository.findById(id);
		return Proprietario.orElse(null);
	}
	//Query Method
	public List<Proprietario> getProprietariosPorNome(String nome){
		return proprietarioRepository.findByNome(nome);
	}
	//@Query
	public List<Proprietario> findByCidade(String cidade){
		return proprietarioRepository.findByCidade(cidade);
	}
	//@Query
	public List<Proprietario> findByLogradouro(String logradouro){
		return proprietarioRepository.findByLogradouro(logradouro);
	}
	//@Query
	public List<Proprietario> findByCpf(String cpf){
		return proprietarioRepository.findByCpf(cpf);
	}


	public Proprietario salvarProprietario(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}

	public Proprietario updateProprietario(Long id, Proprietario updatedProprietario) {
		Optional<Proprietario> existingProprietario = proprietarioRepository.findById(id);
		if (existingProprietario.isPresent()) {
			updatedProprietario.setId(id);
			return proprietarioRepository.save(updatedProprietario);
		}
		return null;
	}

	public boolean deleteProprietario(Long id) {
		Optional<Proprietario> existingProprietario = proprietarioRepository.findById(id);
		if (existingProprietario.isPresent()) {
			proprietarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}



