package br.com.broso.biblioteca.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.broso.biblioteca.controller.dto.DetalharLivroDto;
import br.com.broso.biblioteca.controller.form.AtualizarLivroForm;
import br.com.broso.biblioteca.controller.form.LivroForm;
import br.com.broso.biblioteca.dto.LivroDto;
import br.com.broso.biblioteca.model.Livro;
import br.com.broso.biblioteca.repository.AutorRepository;
import br.com.broso.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<LivroDto> lista(String titulo) {
		if (titulo == null) {
			List<Livro> livro = livroRepository.findAll();
			return LivroDto.converter(livro);
		} else {
			List<Livro> livro = livroRepository.findByTitulo(titulo);
			return LivroDto.converter(livro);
		}
	}
	
	@PostMapping
	public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody @Valid LivroForm livroForm, UriComponentsBuilder uriBuilder) {
		Livro livro = livroForm.converter(autorRepository);
		livroRepository.save(livro);
		
		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}
	
	@GetMapping("/{id}")
	public DetalharLivroDto detalhar(@PathVariable Long id) {
		Livro livro = livroRepository.getReferenceById(id);
		return new DetalharLivroDto(livro);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarLivroForm atualizarLivroForm) {
		Livro livro = atualizarLivroForm.atualizar(id, livroRepository);
		
		return ResponseEntity.ok(new LivroDto(livro));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		livroRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}