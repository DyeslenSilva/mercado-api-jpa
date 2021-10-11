package api.mercado.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerJPA {
	

	/***
	 * 
	 * @return
	 *Metodo responsavel por criar um objeto do tipo EntityManager
	 *para manipulação do banco de dados.
	 */
	
	public static EntityManager entityManager() {
			EntityManagerFactory entityManagerFactory = null;
			EntityManager entityManager = null;
			
			String entManager = "cliente";
			entityManagerFactory = Persistence.createEntityManagerFactory(entManager);
			entityManager  = entityManagerFactory.createEntityManager();
			return entityManager;
	}

}
