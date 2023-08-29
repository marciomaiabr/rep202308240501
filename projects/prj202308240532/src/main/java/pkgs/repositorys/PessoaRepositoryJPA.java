package pkgs.repositorys;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pkgs.models.Pessoa;

@ManagedBean
public class PessoaRepositoryJPA implements PessoaRepository {

	public PessoaRepositoryJPA() {
		System.out.println("PessoaRepositoryJPA.PessoaRepositoryJPA()");
	}

	public boolean salvar(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.salvar()");

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

	public List<Pessoa> listar() {
		System.out.println("PessoaRepositoryJPA.listar()");

		List<Pessoa> pessoas = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("myPUNoCreate");
			em = emf.createEntityManager();

			pessoas = em.createQuery(" from Pessoa ", Pessoa.class).getResultList();
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

		return pessoas;
	}

	public Pessoa buscaPorId(Integer id) {
		System.out.println("PessoaRepositoryJPA.buscaPorId()");

		Pessoa pessoa = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("myPUNoCreate");
			em = emf.createEntityManager();

			pessoa = em.find(Pessoa.class, id);
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

		return pessoa;
	}

}
