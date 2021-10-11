package api.mercado.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import api.mercado.entity.Funcionario;
import api.mercado.manager.EntityManagerJPA;

public class FuncionarioDAO {

	private EntityManager entityManager;
	
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		if(funcionario.getIdFuncionario()==null) {
			entityManager.persist(funcionario);
		}else {
			funcionario = entityManager.merge(funcionario);
		}	
		entityManager.getTransaction().commit();
		return funcionario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> getFuncionarios(){
		EntityManagerJPA.entityManager();
		String listaDeFuncionarios = "select * from funcionarios";
		Query query = entityManager.createNamedQuery(listaDeFuncionarios);
		return query.getResultList();
	}
	
	
	public Funcionario getFuncionario(Long idFuncionario) {
		EntityManagerJPA.entityManager();
		Funcionario funcionario = null;
		funcionario = entityManager.find(Funcionario.class,idFuncionario);
		return funcionario;
	}
	
	public void updateFuncionario(Funcionario funcionario) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(funcionario);
		entityManager.getTransaction().commit();
	}
	
	
	public void deleteFuncionario(Long idFuncionario) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		Funcionario funcionario = getFuncionario(idFuncionario);
		entityManager.remove(funcionario);
		entityManager.getTransaction().commit();
	}
}
