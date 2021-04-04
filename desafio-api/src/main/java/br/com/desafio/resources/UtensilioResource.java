package br.com.desafio.resources;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dto.UtensilioDTO;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Utensilio;
import br.com.desafio.services.UtensilioService;

@RestController
@CrossOrigin
@RequestMapping("/utensilio")
public class UtensilioResource {
	
	@Autowired
	private UtensilioService utensilioService;
	
	@GetMapping()
	public ResponseEntity<?> buscarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(utensilioService.buscarTodosDto());
	}
	
	@GetMapping("/{utensilioId}")
	public ResponseEntity<?> buscarUtensilio(@PathVariable Long utensilioId){
		Optional<UtensilioDTO> utensilioDtoOpt = utensilioService.buscarDto(utensilioId);
		if(utensilioDtoOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(utensilioDtoOpt.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<?> salvar(@RequestBody UtensilioDTO utensilioDTO){
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setPessoa(utensilioDTO);
			utensilioService.salvarPessoa(pessoa);
			
			Utensilio utensilio = new Utensilio();
			utensilio.setDescricao(utensilioDTO.getDescricao());
			utensilio.setPessoa(pessoa);
			utensilioService.salvar(utensilio);
			
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{utensilioId}")
	public ResponseEntity<?> alterar(@PathVariable Long utensilioId, @RequestBody UtensilioDTO utensilioDTO){
		try {
			Optional<Utensilio> optUtensilio = utensilioService.buscar(utensilioId);
			if(optUtensilio.isPresent()) {
				Utensilio utensilio = optUtensilio.get();
				utensilio.setDescricao(utensilioDTO.getDescricao());
				utensilioService.salvar(utensilio);
				
				Pessoa pessoa = utensilio.getPessoa();
				pessoa.setPessoa(utensilioDTO);
				utensilioService.salvarPessoa(pessoa);
				
				return ResponseEntity.ok().build();
			}
			
			return ResponseEntity.notFound().build();
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{utensilioId}")
	public ResponseEntity<?> delete(@PathVariable Long utensilioId){
		Optional<UtensilioDTO> utensilioDTOOpt = utensilioService.buscarDto(utensilioId);
		if(utensilioDTOOpt.isPresent()) {
			utensilioService.remover(utensilioId);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("doar/{utensilioId}")
	public ResponseEntity<?> doar(@PathVariable Long utensilioId){
		Optional<Utensilio> utensilioOpt = utensilioService.buscar(utensilioId);
		if(utensilioOpt.isPresent()) {
			utensilioService.doar(utensilioOpt.get());
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
