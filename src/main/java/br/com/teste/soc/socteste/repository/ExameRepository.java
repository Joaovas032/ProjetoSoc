package br.com.teste.soc.socteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.soc.socteste.modelos.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

}
