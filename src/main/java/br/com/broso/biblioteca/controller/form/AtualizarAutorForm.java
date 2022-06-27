package br.com.broso.biblioteca.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.broso.biblioteca.model.Autor;
import br.com.broso.biblioteca.model.Livro;
import br.com.broso.biblioteca.repository.AutorRepository;

public class AtualizarAutorForm {

	@NotNull
	@NotEmpty
	@Length(max = 100)
	private String nome;
	@NotNull
	@NotEmpty
	@Length(max = 100)
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

	public Autor atualizar(Long id, AutorRepository autorRepository) {
		Autor autor = autorRepository.getReferenceById(id);
		autor.setNome(this.nome);
		autor.setBiografia(this.biografia);
		return autor;
	}

}
