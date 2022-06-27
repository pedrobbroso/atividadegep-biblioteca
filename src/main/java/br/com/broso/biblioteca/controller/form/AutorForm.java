package br.com.broso.biblioteca.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.broso.biblioteca.model.Autor;
import br.com.broso.biblioteca.repository.AutorRepository;

public class AutorForm {

	@NotNull @NotEmpty @Length(max=100)
	private String nome;
	@NotNull @NotEmpty @Length(max=100)
	private String biografia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Autor converter(AutorRepository autorRepository) {
		return new Autor(nome, biografia);
	}

}
