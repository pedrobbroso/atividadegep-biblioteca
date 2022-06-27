package br.com.broso.biblioteca.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.broso.biblioteca.model.Autor;
import br.com.broso.biblioteca.model.Livro;
import br.com.broso.biblioteca.repository.AutorRepository;
import br.com.broso.biblioteca.repository.LivroRepository;

public class LivroForm {

	@NotNull @NotEmpty @Length(max=200)
	private String titulo;
	@NotNull @NotEmpty @Length(max=4)
	private String anoLancamento;
	@NotNull @NotEmpty
	private String autorLivro;
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public Livro converter(AutorRepository autorRepository) {
		Autor autor = autorRepository.findByNome(autorLivro);
		return new Livro(titulo, anoLancamento, autor);
	}

}
