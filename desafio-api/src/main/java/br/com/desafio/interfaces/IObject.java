package br.com.desafio.interfaces;

import java.util.List;
import java.util.Optional;

public interface IObject<T,L,U> {
	
	List<L> buscarTodosDto();
	
	Optional<U> buscarDto(Long id);
	
	Optional<T> buscar(Long id);
	
	T salvar(T t);
	
	void remover(Long id);

}
