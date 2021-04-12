package br.gov.fatec.forumFatec.controller.form;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.gov.fatec.forumFatec.modelo.Materia;
import br.gov.fatec.forumFatec.modelo.Topico;
import br.gov.fatec.forumFatec.repository.MateriaRepository;



public class TopicoForm {
	
	@NotNull @NotEmpty @Size(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Size(min = 10)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeMateria;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public Topico converter(MateriaRepository materiaRepository) {
		Materia materia = materiaRepository.findByNome(nomeMateria);
		return new Topico(titulo, mensagem, materia);
	}
	
	
}
