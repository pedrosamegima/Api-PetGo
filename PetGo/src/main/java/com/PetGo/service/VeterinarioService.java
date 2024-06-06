package com.PetGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetGo.entities.Veterinario;
import com.PetGo.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
	private final VeterinarioRepository veterinarioRepository;

	@Autowired
	public VeterinarioService(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}

	public List<Veterinario> getAllVeterinario() {
		return veterinarioRepository.findAll();
	}

	public Veterinario getVeterinarioById(Long id) {
		Optional<Veterinario> Veterinario = veterinarioRepository.findById(id);
		return Veterinario.orElse(null);
	}
	//Query Method
	public List<Veterinario> getVeterinarioPorNome(String data){
		return veterinarioRepository.findByNome(data);
	}
	//@Query
	public List<Veterinario> findByCrmv(String crmv){
		return veterinarioRepository.findByCrmv(crmv);
	}
	//@Query
	public List<Veterinario> findByLogradouro(String logradouro){
		return veterinarioRepository.findByLogradouro(logradouro);
	}
	//@Query
		public List<Veterinario> findByCidade(String Cidade){
			return veterinarioRepository.findByCidade(Cidade);
	}

	public Veterinario salvarVeterinario(Veterinario veterinario) {
		return veterinarioRepository.save(veterinario);
	}

	public Veterinario updateVeterinario(Long id, Veterinario updatedVeterinario) {
		Optional<Veterinario> existingVeterinario = veterinarioRepository.findById(id);
		if (existingVeterinario.isPresent()) {
			updatedVeterinario.setId(id);
			return veterinarioRepository.save(updatedVeterinario);
		}
		return null;
	}

	public boolean deleteVeterinario(Long id) {
		Optional<Veterinario> existingVeterinario = veterinarioRepository.findById(id);
		if (existingVeterinario.isPresent()) {
			veterinarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
