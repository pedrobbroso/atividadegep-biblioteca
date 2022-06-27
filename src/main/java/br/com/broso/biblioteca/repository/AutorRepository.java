package br.com.broso.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.broso.biblioteca.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByNome(String nome);

}
