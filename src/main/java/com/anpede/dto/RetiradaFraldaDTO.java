package com.anpede.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.anpede.entities.RetiradaFralda;

public class RetiradaFraldaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer quantidade;
	private LocalDate dataRetirada;
	
	public RetiradaFraldaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RetiradaFraldaDTO(Long id, Integer quantidade, LocalDate dataRetirada) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.dataRetirada = dataRetirada;
	}
	
	public RetiradaFraldaDTO (RetiradaFralda entity) {
		this.id = entity.getId();
		this.quantidade = entity.getQuantidade();
		this.dataRetirada = entity.getDataRetirada();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	
	
}
