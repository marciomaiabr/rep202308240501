package pkgs.repositorys;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import pkgs.models.Pessoa;
import pkgs.util.Util;

@ManagedBean
public class PessoaRepositoryJPA implements PessoaRepository {

	EntityManager entityManager = null;

	public PessoaRepositoryJPA() {
		System.out.println("PessoaRepositoryJPA.PessoaRepositoryJPA()");
		entityManager = (EntityManager) Util.buscaRequestAttribute("entityManager");
	}

	public boolean salvar(Pessoa pessoa) {
		System.out.println("PessoaRepositoryJPA.salvar()");

		boolean r = false;

		entityManager.merge(pessoa);
		r = true;

		return r;
	}

	public List<Pessoa> listar() {
		System.out.println("PessoaRepositoryJPA.listar()");

		return entityManager.createQuery(" from Pessoa ", Pessoa.class).getResultList();
	}

	public Pessoa buscaPorId(Integer id) {
		System.out.println("PessoaRepositoryJPA.buscaPorId()");

		return entityManager.find(Pessoa.class, id);
	}

}
