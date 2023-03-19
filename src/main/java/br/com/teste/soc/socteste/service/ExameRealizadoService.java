package br.com.teste.soc.socteste.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.soc.socteste.modelos.Exame;
import br.com.teste.soc.socteste.modelos.ExamesRealizados;
import br.com.teste.soc.socteste.modelos.Funcionario;
import br.com.teste.soc.socteste.repository.ExamesRealizadosRepository;

@Service
public class ExameRealizadoService {

	@Autowired
	private ExamesRealizadosRepository exameRealizadoRepository;

	public ExamesRealizados salvar(ExamesRealizados exameRealizado) {
		if (exameRealizadoRepository.FuncionarioEExameEDataRealizacao(exameRealizado.getFuncionario(),
				exameRealizado.getExame(), exameRealizado.getDataExame())) {
			throw new IllegalArgumentException(
					"Já existe um exame realizado pelo funcionário para o mesmo tipo de exame e data de realização.");
		}
		return exameRealizadoRepository.save(exameRealizado);
	}

	public void deletar(Long id) {
		exameRealizadoRepository.deleteById(id);
	}

	public ExamesRealizados atualizar(ExamesRealizados exameRealizado) {
		return exameRealizadoRepository.save(exameRealizado);
	}

	public List<ExamesRealizados> buscarPorFuncionario(Funcionario funcionario) {
		return exameRealizadoRepository.findByFuncionario(funcionario);
	}

	public List<ExamesRealizados> buscarPorExame(Exame exame) {
		return exameRealizadoRepository.findByExame(exame);
	}

	public List<ExamesRealizados> buscarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		
		return null;
	}


	

	
}
