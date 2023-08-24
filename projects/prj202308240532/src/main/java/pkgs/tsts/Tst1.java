package pkgs.tsts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pkgs.models.ObjetoX;

public class Tst1 {

	public static void main(String[] args) {
		m2();
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
			objetoX.setDescricao("Teste descrição...");

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

}
