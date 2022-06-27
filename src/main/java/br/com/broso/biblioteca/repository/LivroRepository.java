package br.com.broso.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.broso.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	List<Livro> findByTitulo(String titulo);


}
