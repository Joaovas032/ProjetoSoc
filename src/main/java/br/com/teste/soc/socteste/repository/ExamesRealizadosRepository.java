package br.com.teste.soc.socteste.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.teste.soc.socteste.modelos.Exame;
import br.com.teste.soc.socteste.modelos.ExamesRealizados;
import br.com.teste.soc.socteste.modelos.Funcionario;

@Repository
public interface ExamesRealizadosRepository extends JpaRepository<ExamesRealizados, Long> {

	List<ExamesRealizados> findByFuncionario(Funcionario funcionario);

	List<ExamesRealizados> findByExame(Exame exame);

	List<ExamesRealizados> findByDataExame(Date dataInicial, Date dataFinal);

	@Query("SELECT COUNT(e) > 0 FROM ExameRealizado e WHERE e.funcionario = :funcionario AND e.exame = :exame AND e.dataExame = :dataExame")
	boolean FuncionarioEExameEDataRealizacao(@Param("funcionario") Funcionario funcionario, @Param("exame") Exame exame,
			@Param("dataExame") LocalDate dataRealizacao);
}
