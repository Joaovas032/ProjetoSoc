package br.com.teste.soc.socteste.DAO;

import java.util.List;

import br.com.teste.soc.socteste.modelos.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class FuncionarioDAO {

	private EntityManager em;

	public FuncionarioDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
	}

	public void atualizar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
	}

	public Funcionario buscarPorId(Long id) {
		return em.find(Funcionario.class, id);
	}

	public void deletar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
	}

	public List<Funcionario> buscarTodos() {
		TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
		return query.getResultList();
	}
}
