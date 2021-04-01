package br.com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.dto.UtensilioDTO;
import br.com.desafio.interfaces.IObject;
import br.com.desafio.model.Utensilio;
import br.com.desafio.repository.UtensilioRepository;

@Service
public class UtensilioService implements IObject<Utensilio, UtensilioDTO> {

	@Autowired
	private UtensilioRepository utensilioRepository;
	
	@Override
	public List<Utensilio> buscarTodos() {
		return utensilioRepository.findAll();
	}

	@Override
	public List<UtensilioDTO> buscarTodosDto() {
		return utensilioRepository.ListUtensilioDTO();
	}

	@Override
	public Optional<Utensilio> buscar(Long id) {
		return utensilioRepository.findById(id);
	}

	@Override
	public Optional<UtensilioDTO> buscarDto(Long id) {
		return utensilioRepository.findUtensilioDTO(id);
	}

	@Override
	public Utensilio salvar(Utensilio utensilio) {
		return utensilioRepository.save(utensilio);
	}

	@Override
	public void remover(Long id) {
		utensilioRepository.deleteById(id);		
	}

}
