package br.com.desafio.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.services.PessoaService;

@RestController
@CrossOrigin
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public ResponseEntity<?> buscarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarTodosDto());
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<?> buscarPessoa(@PathVariable Long pessoaId){
		Optional<PessoaDTO> pessoaDtoOpt = pessoaService.buscarDto(pessoaId);
		if(pessoaDtoOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(pessoaDtoOpt.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	

}
