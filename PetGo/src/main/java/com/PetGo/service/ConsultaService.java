package com.PetGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PetGo.entities.Consulta;
import com.PetGo.repository.ConsultaRepository;

@Service
public class ConsultaService {
	private final ConsultaRepository consultaRepository;

	@Autowired
	public ConsultaService(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}

	public List<Consulta> getAllConsulta() {
		return consultaRepository.findAll();
	}

	public Consulta getConsultaById(Long id) {
		Optional<Consulta> Consulta = consultaRepository.findById(id);
		return Consulta.orElse(null);
	}
	//Query Method
	public List<Consulta> getConsultaPorData(String data){
		return consultaRepository.findByData(data);
	}
	//@Query
	public List<Consulta> findByHora(String hora){
		return consultaRepository.findByHora(hora);
	}
	//@Query
	public List<Consulta> findByDescricao(String descricao){
		return consultaRepository.findByHora(descricao);
	}

	public Consulta salvarConsulta(Consulta consulta) {
		return consultaRepository.save(consulta);
	}

	public Consulta updateConsulta(Long id, Consulta updatedConsulta) {
		Optional<Consulta> existingConsulta = consultaRepository.findById(id);
		if (existingConsulta.isPresent()) {
			updatedConsulta.setId(id);
			return consultaRepository.save(updatedConsulta);
		}
		return null;
	}

	public boolean deleteConsulta(Long id) {
		Optional<Consulta> existingConsulta = consultaRepository.findById(id);
		if (existingConsulta.isPresent()) {
			consultaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
