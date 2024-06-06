package com.PetGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetGo.entities.Tipo;
import com.PetGo.repository.TipoRepository;

@Service
public class TipoService {
	private final TipoRepository tipoRepository;

	@Autowired
	public TipoService(TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
	}

	public List<Tipo> getAllTipo() {
		return tipoRepository.findAll();
	}

	public Tipo getTipoById(Long id) {
		Optional<Tipo> Tipo = tipoRepository.findById(id);
		return Tipo.orElse(null);
	}
	public Tipo salvarTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	public Tipo updateTipo(Long id, Tipo updatedTipo) {
		Optional<Tipo> existingTipo = tipoRepository.findById(id);
		if (existingTipo.isPresent()) {
			updatedTipo.setId(id);
			return tipoRepository.save(updatedTipo);
		}
		return null;
	}

	public boolean deleteTipo(Long id) {
		Optional<Tipo> existingTipo = tipoRepository.findById(id);
		if (existingTipo.isPresent()) {
			tipoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}



