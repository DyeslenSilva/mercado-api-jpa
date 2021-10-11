package api.mercado.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import api.mercado.entity.Produto;
import api.mercado.manager.EntityManagerJPA;

public class ProdutoDAO {

	private EntityManager entityManager;
	
	public Produto cadastraProduto(Produto produto) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		if(produto.getIdProduto()==null) {
			entityManager.persist(produto);
		}else {
			 produto =  entityManager.merge(produto);
		}
		return produto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos(){
		EntityManagerJPA.entityManager();
		String listaDeProdutos = "select * from produtos";
		Query query = entityManager.createNamedQuery(listaDeProdutos);
		return query.getResultList();
	}
	
	public Produto getProduto(Long idProduto) {
		EntityManagerJPA.entityManager();
		Produto produto =null;
		produto = entityManager.find(Produto.class, idProduto);
		return produto;
	}
	
	public void updateProduto(Produto produto) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();
	}
	
	public void deleteProduto(Long idProduto) {
		EntityManagerJPA.entityManager();
		entityManager.getTransaction().begin();
		Produto produto = getProduto(idProduto);
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
	}
}
