package br.com.desafio.interfaces;

import java.util.List;
import java.util.Optional;

public interface IObject<T,D> {
	
	List<T> buscarTodos();
	
	List<D> buscarTodosDto();
	
	Optional<T> buscar(Long id);
	
	Optional<D> buscarDto(Long id);
	
	T salvar(T t);
	
	void remover(Long id);

}
