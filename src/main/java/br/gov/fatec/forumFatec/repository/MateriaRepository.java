package br.gov.fatec.forumFatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.forumFatec.modelo.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
	
	Materia findByNome(String nomeMateria);

}
