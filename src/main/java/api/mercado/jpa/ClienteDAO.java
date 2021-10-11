package api.mercado.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import api.mercado.entity.Cliente;
import api.mercado.manager.EntityManagerJPA;

public class ClienteDAO {
		
	private EntityManager entityManager;
	
	public Cliente salvarCliente(Cliente cliente) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		if(cliente.getIdCliente()==null) {
			entityManager.persist(cliente);
		}else {
			cliente = entityManager.merge(cliente);
		}
		
		entityManager.getTransaction().commit();
		
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(){
		EntityManagerJPA.entityManager();
		String listaDeClientes = "select * from clientes";
		Query query = entityManager.createNamedQuery(listaDeClientes);
		return  query.getResultList();
	}
	
	public Cliente getClienteByID(Long idCliente) {
		EntityManagerJPA.entityManager();
		Cliente cliente = null;
		cliente  = entityManager.find(Cliente.class, idCliente);
		return cliente;
	}
	
	public void updateCliente(Cliente cliente) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
	}
	
	public void deleteCliente(Long idCliente) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		Cliente cliente  =getClienteByID(idCliente);
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
	}
	
}
