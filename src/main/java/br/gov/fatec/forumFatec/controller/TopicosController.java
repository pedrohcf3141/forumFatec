package br.gov.fatec.forumFatec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.fatec.forumFatec.controller.dto.DetalhesTopicoDto;
import br.gov.fatec.forumFatec.controller.dto.TopicoDto;
import br.gov.fatec.forumFatec.controller.form.AtualizacaoTopicoForm;
import br.gov.fatec.forumFatec.controller.form.TopicoForm;
import br.gov.fatec.forumFatec.modelo.Topico;
import br.gov.fatec.forumFatec.repository.MateriaRepository;
import br.gov.fatec.forumFatec.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeMateria) {
		if (nomeMateria == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByMateriaNome(nomeMateria);
			return TopicoDto.converter(topicos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Validated TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(materiaRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesTopicoDto> detalhar(@PathVariable Long id) {
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DetalhesTopicoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoTopicoForm form){
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
		Topico topico = form.atualizar(id, topicoRepository);
		return ResponseEntity.ok(new TopicoDto(topico));
		}
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity remover(@PathVariable Long id){
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}
	
}
