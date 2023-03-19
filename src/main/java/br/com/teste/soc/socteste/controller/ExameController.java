package br.com.teste.soc.socteste.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import br.com.teste.soc.socteste.modelos.ExamesRealizados;
import br.com.teste.soc.socteste.service.ExameRealizadoService;

@Controller
@RequestMapping("/exames")
public class ExameController {

	@Autowired
	private final ExameRealizadoService exameRealizadoService;

	public ExameController(ExameRealizadoService exameRealizadoService) {
		this.exameRealizadoService = exameRealizadoService;
	}

	@PostMapping
	public ResponseEntity<ExamesRealizados> salvar(@RequestBody ExamesRealizados examesRealizados) {
		ExamesRealizados exameRealizadoSalvo = exameRealizadoService.salvar(examesRealizados);
		return ResponseEntity.status(HttpStatus.CREATED).body(exameRealizadoSalvo);
	}

	@GetMapping
	public ResponseEntity<List<ExamesRealizados>> buscarPorPeriodo(
			@RequestParam("dataInicial") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFinal) {
		List<ExamesRealizados> examesRealizados = exameRealizadoService.buscarPorPeriodo(dataInicial, dataFinal);
		return ResponseEntity.ok(examesRealizados);
	}

}
