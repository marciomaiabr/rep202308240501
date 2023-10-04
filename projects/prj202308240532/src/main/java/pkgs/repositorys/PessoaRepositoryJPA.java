package pkgs.repositorys;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import pkgs.models.AreaAtuacao;
import pkgs.models.Pessoa;
import pkgs.util.JSFUtil;

@ManagedBean
public class PessoaRepositoryJPA implements PessoaRepository {

	EntityManager entityManager = null;

	public PessoaRepositoryJPA() {
		System.out.println("PessoaRepositoryJPA.PessoaRepositoryJPA()");
		entityManager = (EntityManager) JSFUtil.buscaRequestAttribute("entityManager");
	}

	public PessoaRepositoryJPA(EntityManager entityManager) {
		System.out.println("PessoaRepositoryJPA.PessoaRepositoryJPA(EntityManager entityManager)");
		this.entityManager = entityManager;
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

	@Override
	public List<AreaAtuacao> listarAreasAtuacao() {
		//return entityManager.createQuery(" from AreaAtuacao ", AreaAtuacao.class).getResultList();
		return entityManager.createQuery(" select distinct aa from AreaAtuacao aa join fetch aa.subAreaAtuacao ", AreaAtuacao.class).getResultList();
	}

	@Override
	public AreaAtuacao getAreaAtuacaoById(Integer id) {
		return entityManager.find(AreaAtuacao.class, id);
	}

}
