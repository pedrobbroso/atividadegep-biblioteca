package br.com.broso.biblioteca.controller.dto;

import br.com.broso.biblioteca.model.Livro;

public class DetalharLivroDto {

	private Long id;
	private String titulo;
	private String anoLancamento;
	private String autorLivro;
	
	public DetalharLivroDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.anoLancamento = livro.getAnoLancamento();
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

	public String getAutorLivro() {
		return autorLivro;
	}
	
	
	
}
