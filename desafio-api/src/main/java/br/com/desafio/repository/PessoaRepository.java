package br.com.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("Select new br.com.desafio.dto.PessoaDTO("
			+ "p.id, p.nomeCompleto, p.cpf, "
			+ "p.dataNascimento, p.dataCadastro, p.telefone," + 
			" p.celular, p.email) from Pessoa p")
	List<PessoaDTO> ListPessoaDTO();
	
	@Query("Select new br.com.desafio.dto.PessoaDTO("
			+ "p.id, p.nomeCompleto, p.cpf, "
			+ "p.dataNascimento, p.dataCadastro, p.telefone," + 
			" p.celular, p.email) from Pessoa p "
			+ "where p.id = ?1")
	Optional<PessoaDTO> findPessoaDTO(Long id);
	
}
