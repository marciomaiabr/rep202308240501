package pkgs.util;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pkgs.models.ObjetoX;

public class JPAUtil {

	public static void testaJPA() {
		System.out.println("testes com o JPA...");

		ObjetoX objetoX = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;

		try {

			emf = Persistence.createEntityManagerFactory("myPUCreate");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			objetoX = new ObjetoX();
			objetoX.setDescricao("Teste com JPA descrição...");

			em.merge(objetoX);

			et.commit();
			em.close();
			emf.close();

			emf = Persistence.createEntityManagerFactory("myPUNoCreate");
			em = emf.createEntityManager();

			objetoX = em.find(ObjetoX.class, 1);

			System.out.println("[objetoX=" + objetoX + "]");

			em.close();
			emf.close();

			System.out.println("testes com o JPA executados com sucesso...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createDatabase() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPUCreate");
			em = emf.createEntityManager();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
