package com.PetGo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veterinario")
public class Veterinario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 100)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String telefone1;
	
	private String telefone2;
	
	private String logradouro;
	
	private String cep;
	
	private String uf;
	
	private String numCasa;
	
	private String cidade;
	
	private String complemento;
	
	private String crmv;
	
	@ManyToOne
	@JoinColumn(name = "id_especialidade")
	private Especialidade especialidade;
}
