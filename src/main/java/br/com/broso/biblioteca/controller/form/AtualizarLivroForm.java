package br.com.broso.biblioteca.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.broso.biblioteca.model.Livro;
import br.com.broso.biblioteca.repository.LivroRepository;

public class AtualizarLivroForm {

	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String titulo;
	@NotNull
	@NotEmpty
	@Length(max = 4)
	private String anoLancamento;

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

	public Livro atualizar(Long id, LivroRepository livroRepository) {
		Livro livro = livroRepository.getReferenceById(id);
		livro.setTitulo(this.titulo);
		livro.setAnoLancamento(this.anoLancamento);
		return livro;
	}

}
