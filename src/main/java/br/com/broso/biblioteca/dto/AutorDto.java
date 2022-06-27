package br.com.broso.biblioteca.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.broso.biblioteca.model.Autor;

public class AutorDto {

	private Long id;
	private String nome;
	private String biografia;

	public AutorDto(Autor autor) {
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

	public static List<AutorDto> converter(List<Autor> autor) {
		return autor.stream().map(AutorDto::new).collect(Collectors.toList());
	}

}