package com.PetGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.PetGo.entities.Especialidade;
import com.PetGo.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	private final EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
		this.especialidadeRepository = especialidadeRepository;
	}

	public List<Especialidade> getAllEspecialidade() {
		return especialidadeRepository.findAll();
	}

	public Especialidade getEspecialidadeById(Long id) {
		Optional<Especialidade> Especialidade = especialidadeRepository.findById(id);
		return Especialidade.orElse(null);
	}
	

	public Especialidade salvarEspecialidade(Especialidade especialidade) {
		return especialidadeRepository.save(especialidade);
	}

	public Especialidade updateEspecialidade(Long id, Especialidade updatedEspecialidade) {
		Optional<Especialidade> existingEspecialidade = especialidadeRepository.findById(id);
		if (existingEspecialidade.isPresent()) {
			updatedEspecialidade.setId(id);
			return especialidadeRepository.save(updatedEspecialidade);
		}
		return null;
	}

	public boolean deleteEspecialidade(Long id) {
		Optional<Especialidade> existingEspecialidade = especialidadeRepository.findById(id);
		if (existingEspecialidade.isPresent()) {
			especialidadeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
