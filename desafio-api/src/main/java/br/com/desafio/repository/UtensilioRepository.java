package br.com.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.dto.ListagemUtensilioDTO;
import br.com.desafio.dto.UtensilioDTO;
import br.com.desafio.model.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Long> {

	@Query("Select new br.com.desafio.dto.ListagemUtensilioDTO("
			+ "u.id, u.descricao, u.dataDoacao, p.nomeCompleto) "
			+ "from Utensilio u "
			+ "join u.pessoa p")
	List<ListagemUtensilioDTO> ListUtensilioDTO();
	
	@Query("Select new br.com.desafio.dto.UtensilioDTO("
			+ "p.nomeCompleto, p.cpf, "
			+ "p.dataNascimento, p.telefone," + 
			" p.celular, p.email, u.descricao)"
			+ "from Utensilio u "
			+ "join u.pessoa p "
			+ "where u.id = ?1")
	Optional<UtensilioDTO> findUtensilioDTO(Long id);
}
