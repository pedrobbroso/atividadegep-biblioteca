package br.com.broso.biblioteca.controller.dto;

import br.com.broso.biblioteca.model.Autor;

public class DetalharAutorDto {

	private Long id;
	private String nome;
	private String biografia;
	
	public DetalharAutorDto(Autor autor) {
		super();
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.biografia = autor.getBiografia();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getBiografia() {
		return biografia;
	}
	
}
