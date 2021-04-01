package br.com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.interfaces.IObject;
import br.com.desafio.model.Pessoa;
import br.com.desafio.repository.PessoaRepository;

@Service
public class PessoaService implements IObject<Pessoa, PessoaDTO> {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> buscarTodos() {		
		return pessoaRepository.findAll();
	}

	@Override
	public List<PessoaDTO> buscarTodosDto(int page, int linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page,linesPerPage);
		return pessoaRepository.ListPessoaDTO(pageRequest).getContent();
	}

	@Override
	public Optional<Pessoa> buscar(Long id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public Optional<PessoaDTO> buscarDto(Long id) {
		return pessoaRepository.findPessoaDTO(id);
	}

	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void remover(Long id) {
		pessoaRepository.deleteById(id);		
	}

}
