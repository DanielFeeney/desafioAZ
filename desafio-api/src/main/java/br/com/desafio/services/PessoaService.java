package br.com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.interfaces.IObject;
import br.com.desafio.model.Pessoa;

@Service
public class PessoaService implements IObject<Pessoa, PessoaDTO> {

	@Override
	public List<Pessoa> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaDTO> buscarTodosDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pessoa> buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PessoaDTO> buscarDto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa salvar(Pessoa t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

}
