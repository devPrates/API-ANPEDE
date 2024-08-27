package com.anpede.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.anpede.dto.EmprestimoDTO;
import com.anpede.entities.Emprestimo;
import com.anpede.repositories.EmprestimoRepository;
import com.anpede.services.exceptions.ResourceNotFoundException;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;
	
	@Transactional(readOnly = true)
	public List<EmprestimoDTO> findAll(){		
		List<Emprestimo> list = repository.findAll();
		return list.stream().map(a -> new EmprestimoDTO(a)).collect(Collectors.toList());		
	}
	
	@Transactional(readOnly = true)
	public EmprestimoDTO findById(Long id) {
		Optional<Emprestimo> obj = repository.findById(id);
		Emprestimo entity = obj.orElseThrow(() -> 
			new ResourceNotFoundException("O registro não localizado na base de dados"));
		return new EmprestimoDTO(entity);
	}
	
	private void converterDtoEmEntidade(EmprestimoDTO dto, Emprestimo entity) {
		entity.setDataRetirada(dto.getDataRetirada());
		entity.setDataDevolucao(dto.getDataDevolucao());
		entity.setEquipamentoItem(dto.getEquipamento());
		
	}
	
	@Transactional
	public EmprestimoDTO insert(EmprestimoDTO dto) {
		Emprestimo entity = new Emprestimo();
		converterDtoEmEntidade(dto, entity);					
		entity = repository.save(entity);
		return new EmprestimoDTO(entity);
	}
	
	
}
