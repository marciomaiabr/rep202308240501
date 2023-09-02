package pkgs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pkgs.models.Empresa;

public class HibernateUtil {

	public static void testaHibernate() {
		System.out.println("testes com o hibernate...");

		Empresa empresa = null;

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

			empresa = new Empresa();
			empresa.setRazaoSocial("Teste com hibernate descrição...");

			session.save(empresa);

			t.commit();

			session.close();

			session = sessionFactory.openSession();

			empresa = session.find(Empresa.class, 1);

			System.out.println("[empresa=" + empresa + "]");

			session.close();
			sessionFactory.close();

			System.out.println("testes com o hibernate executados com sucesso...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
