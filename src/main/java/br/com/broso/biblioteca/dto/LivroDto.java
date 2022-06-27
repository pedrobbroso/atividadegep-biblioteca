package br.com.broso.biblioteca.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.broso.biblioteca.model.Autor;
import br.com.broso.biblioteca.model.Livro;

public class LivroDto {

	private Long id;
	private String titulo;
	private String anoLancamento;
	private Autor autor;
	
	//verificar
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.anoLancamento = livro.getAnoLancamento();
		this.autor = livro.getAutor();
	}

	public Autor getAutor() {
		return autor;
	}

	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public static List<LivroDto> converter(List<Livro> livro) {
		return livro.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}