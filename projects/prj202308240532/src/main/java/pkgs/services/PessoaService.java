package pkgs.services;

import java.util.List;

import javax.faces.bean.ManagedBean;

import pkgs.models.Pessoa;
import pkgs.repositorys.PessoaRepository;
import pkgs.repositorys.Repositorys;

@ManagedBean
public class PessoaService {

	public PessoaService() {
		System.out.println("PessoaService.PessoaService()");
	}

	private PessoaRepository pessoaRepository = (PessoaRepository) Repositorys.getRepository();

	public boolean salvar(Pessoa pessoa) {
		return this.pessoaRepository.salvar(pessoa);
	}

	public List<Pessoa> listar() {
		return this.pessoaRepository.listar();
	}

	public Pessoa buscaPorId(Integer id) {
		return this.pessoaRepository.buscaPorId(id);
	}
}
