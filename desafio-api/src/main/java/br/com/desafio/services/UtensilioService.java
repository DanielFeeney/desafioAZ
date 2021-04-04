package br.com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.dto.ListagemUtensilioDTO;
import br.com.desafio.dto.UtensilioDTO;
import br.com.desafio.interfaces.IObject;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Utensilio;
import br.com.desafio.repository.PessoaRepository;
import br.com.desafio.repository.UtensilioRepository;

@Service
public class UtensilioService implements IObject<Utensilio, ListagemUtensilioDTO, UtensilioDTO> {

	@Autowired
	private UtensilioRepository utensilioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<ListagemUtensilioDTO> buscarTodosDto() {
		return utensilioRepository.ListUtensilioDTO();
	}

	@Override
	public Optional<UtensilioDTO> buscarDto(Long id) {
		return utensilioRepository.findUtensilioDTO(id);
	}
	
	@Override
	public Optional<Utensilio> buscar(Long id) {
		return utensilioRepository.findById(id);
	}

	@Override
	public Utensilio salvar(Utensilio utensilio) {
		return utensilioRepository.save(utensilio);
	}

	@Override
	public void remover(Long id) {
		utensilioRepository.deleteById(id);		
	}
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void doar(Utensilio utensilio) {
		utensilio.setDisponivel(false);
		utensilioRepository.save(utensilio);
	}

}
