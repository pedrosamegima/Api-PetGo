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
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 100)
	private Long id;
	
	
	private String nome;
	
	private String dataNasc;
	
	private String NumDoc;
	
	private String raca;
	
	private String cor;
	
	@ManyToOne
	@JoinColumn(name = "id_proprietario")
	private Proprietario proprietario;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	

}
