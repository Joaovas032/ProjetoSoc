package br.com.teste.soc.socteste.DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import br.com.teste.soc.socteste.modelos.ExamesRealizados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ExameRealizadoDao {

	private EntityManager em;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exames_realizados");

	public void ExameRealizadoDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(ExamesRealizados exameRealizado) {
		em.getTransaction().begin();
		em.persist(exameRealizado);
		em.getTransaction().commit();
	}

	public void atualizar(ExamesRealizados exameRealizado) {
		em.getTransaction().begin();
		em.merge(exameRealizado);
		em.getTransaction().commit();
	}

	public ExamesRealizados buscarPorId(Long id) {
		return em.find(ExamesRealizados.class, id);
	}

	public void deletar(ExamesRealizados exameRealizado) {
		em.getTransaction().begin();
		em.remove(exameRealizado);
		em.getTransaction().commit();
	}

	public List<ExamesRealizados> buscarTodos() {
		TypedQuery<ExamesRealizados> query = em.createQuery("SELECT er FROM exames_realizados er", ExamesRealizados.class);
		return query.getResultList();
	}

	public List<ExamesRealizados> buscarPorPeriodo(Date dataInicial, Date dataFinal) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exames_realizados");
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<ExamesRealizados> query = em.createQuery(
					"SELECT er FROM exames_realizados er WHERE er.dataExame BETWEEN :dataInicial AND :dataFinal",
					ExamesRealizados.class);
			query.setParameter("dataInicial", dataInicial);
			query.setParameter("dataFinal", dataFinal);
			return query.getResultList();
		} finally {
			em.close();
			emf.close();
		}
	}
}
