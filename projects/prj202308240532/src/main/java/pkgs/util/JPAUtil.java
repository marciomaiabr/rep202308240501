package pkgs.util;

import java.util.ArrayList;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pkgs.models.AreaAtuacao;
import pkgs.models.Cargo;
import pkgs.models.ObjetoX;
import pkgs.models.SubAreaAtuacao;

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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}
		}
	}

	public static void initialInsert() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPUNoCreate");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();

			AreaAtuacao areaAtuacao = null;
			SubAreaAtuacao subAreaAtuacao = null;

			// insert AreaAtuacao
			em.persist(new AreaAtuacao("Humanas"));
			em.persist(new AreaAtuacao("Exatas"));

			areaAtuacao = em.find(AreaAtuacao.class, 1);

			// insert SubAreaAtuacao
			em.persist(new SubAreaAtuacao(areaAtuacao, "Medicina"));
			em.persist(new SubAreaAtuacao(areaAtuacao, "Psicologia"));
			em.persist(new SubAreaAtuacao(areaAtuacao, "Administração"));

			areaAtuacao = em.find(AreaAtuacao.class, 2);

			em.persist(new SubAreaAtuacao(areaAtuacao, "TI"));
			em.persist(new SubAreaAtuacao(areaAtuacao, "Contabilidade"));
			em.persist(new SubAreaAtuacao(areaAtuacao, "Economia"));

			et.commit();

			em.createQuery("from Cargo", Cargo.class).getResultStream().forEach(System.out::println);

		} catch (Exception e) {
			try {
				et.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}
		}
	}

	public static void execute(Consumer<EntityManager> consumer) {
		System.out.println("JPAUtil.execute()");
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("myPUNoCreate");
			entityManager = entityManagerFactory.createEntityManager();

			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			consumer.accept(entityManager);

			entityTransaction.commit();
		} catch (Exception e) {
			try {
				entityTransaction.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				entityManager.close();
			} catch (Exception e) {
			}
			try {
				entityManagerFactory.close();
			} catch (Exception e) {
			}
		}
	}

}
