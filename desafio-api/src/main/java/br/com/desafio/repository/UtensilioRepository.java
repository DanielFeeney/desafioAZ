package br.com.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.dto.UtensilioDTO;
import br.com.desafio.model.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Long> {

	@Query("Select new br.com.desafio.dto.UtensilioDTO("
			+ "u.id, u.descricao, u.disponivel, u.dataDoacao) "
			+ "from Utensilio u")
	List<UtensilioDTO> ListUtensilioDTO();
	
	@Query("Select new br.com.desafio.dto.UtensilioDTO("
			+ "u.id, u.descricao, u.disponivel, u.dataDoacao) "
			+ "from Utensilio u "
			+ "where u.id = ?1")
	Optional<UtensilioDTO> findUtensilioDTO(Long id);
}
