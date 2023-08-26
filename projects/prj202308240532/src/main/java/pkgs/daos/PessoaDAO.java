package pkgs.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pkgs.models.Pessoa;

public class PessoaDAO {

	public boolean salvar(Pessoa pessoa) {
		System.out.println("PessoaDAO.salvar()");
		
		boolean r = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPUNoCreate");
			em = emf.createEntityManager();
			et = em.getTransaction();

			et.begin();

			em.merge(pessoa);

			et.commit();

			r = true;
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

		return r;
	}

}
