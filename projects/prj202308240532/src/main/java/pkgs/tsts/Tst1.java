package pkgs.tsts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pkgs.models.ObjetoX;

public class Tst1 {

	public static void main(String[] args) {
		m3();
	}

	private static void m1() {
		System.out.println("Olá mundo...");
	}

	private static void m2() {
		System.out.println("testes com o hibernate...");

		ObjetoX objetoX = null;

		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction t = null;

		try {

			config = new Configuration();
			config.configure();

			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();

			t = session.beginTransaction();

			objetoX = new ObjetoX();
			objetoX.setDescricao("Teste com hibernate descrição...");

			session.save(objetoX);

			t.commit();

			session.close();

			session = sessionFactory.openSession();

			objetoX = session.find(ObjetoX.class, 1);

			System.out.println("[objetoX=" + objetoX + "]");

			session.close();
			sessionFactory.close();

			System.out.println("testes com o hibernate executados com sucesso...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
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

}
