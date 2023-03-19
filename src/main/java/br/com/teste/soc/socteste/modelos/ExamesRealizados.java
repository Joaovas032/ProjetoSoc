package br.com.teste.soc.socteste.modelos;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exames_realizados")
public class ExamesRealizados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_exame")
	private Exame exame;

	@Column(nullable = false)
	private LocalDate dataExame;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public LocalDate getDataExame() {
		return dataExame;
	}

	public void setDataExame(LocalDate dataExame) {
		this.dataExame = dataExame;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataExame, exame, funcionario, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamesRealizados other = (ExamesRealizados) obj;
		return Objects.equals(dataExame, other.dataExame) && Objects.equals(exame, other.exame)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(id, other.id);
	}

}
