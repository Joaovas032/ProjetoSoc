package br.com.teste.soc.socteste.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.teste.soc.socteste.modelos.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

@Controller
@RequestMapping
public class FuncionarioController {
	
	
private EntityManagerFactory emf;
    
    public FuncionarioController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @GetMapping
    public void salvarFuncionario(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(funcionario);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    @GetMapping
    public void atualizarFuncionario(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(funcionario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    @GetMapping
    public void deletarFuncionario(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Funcionario funcionario = em.find(Funcionario.class, id);
            em.remove(funcionario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    @GetMapping
    public Funcionario buscarFuncionario(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Funcionario funcionario = em.find(Funcionario.class, id);
            return funcionario;
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
    @GetMapping
    public List<Funcionario> buscarTodosFuncionarios() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
}

