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

import br.com.broso.biblioteca.controller.dto.DetalharAutorDto;
import br.com.broso.biblioteca.controller.form.AtualizarAutorForm;
import br.com.broso.biblioteca.controller.form.AutorForm;
import br.com.broso.biblioteca.dto.AutorDto;
import br.com.broso.biblioteca.dto.LivroDto;
import br.com.broso.biblioteca.model.Autor;
import br.com.broso.biblioteca.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<AutorDto> lista(String nome) {
		if (nome == null) {
			List<Autor> autor = autorRepository.findAll();
			return AutorDto.converter(autor);
		} else {
			@SuppressWarnings("unchecked")
			List<Autor> autor = (List<Autor>) autorRepository.findByNome(nome);
			return AutorDto.converter(autor);
		}
	}

	@PostMapping
	public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder ) {
		Autor autor = autorForm.converter(autorRepository);
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
	
	@GetMapping("/{id}")
	public DetalharAutorDto detalhar(@PathVariable Long id) {
		Autor autor = autorRepository.getReferenceById(id);
		return new DetalharAutorDto(autor);
	}

	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AutorDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarAutorForm atualizarAutorForm) {
		Autor autor = atualizarAutorForm.atualizar(id, autorRepository);
		
		return ResponseEntity.ok(new AutorDto(autor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		autorRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
