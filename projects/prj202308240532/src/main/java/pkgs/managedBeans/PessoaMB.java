package pkgs.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import pkgs.models.Endereco;
import pkgs.models.Pessoa;
import pkgs.repositorys.PessoaRepository;
import pkgs.util.Util;

@ManagedBean
public class PessoaMB {

	public PessoaMB() {
		System.out.println("PessoaMB.PessoaMB()");
	}

	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		System.out.println("PessoaMB.setPessoa()");
		System.out.println("[this.pessoa=" + this.pessoa + "]");
		System.out.println("[pessoa=" + pessoa + "]");
		this.pessoa = pessoa;
	}

	private List<Pessoa> pessoas;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void init() {
		System.out.println("PessoaMB.init()");
		System.out.println("[this.pessoa=" + this.pessoa + "]");

		String cmdBtnSalvar = Util.buscaRequestParameterFormPrincipal("cmdBtnSalvar");

		if (cmdBtnSalvar != null) {
			String idPrincipal = Util.buscaRequestParameterFormPrincipal("idPrincipal");
			if(idPrincipal != null) {
				this.pessoa = new PessoaRepository().buscaPorId(Integer.parseInt(idPrincipal));
			}else {
				this.pessoa = new Pessoa();
				this.pessoa.setEndereco(new Endereco());
				this.pessoa.getEndereco().setPessoa(this.pessoa);				
			}
		}
	}

	public String salvar() {
		System.out.println("PessoaMB.salvar()");
		System.out.println("[this.pessoa=" + this.pessoa + "][this.pessoa.getEndereco()=" + this.pessoa.getEndereco() + "]");
		new PessoaRepository().salvar(pessoa);
		return "listar";
	}

	public void pesquisar() {
		pessoas = new PessoaRepository().listar();
	}

	public List<Pessoa> listar() {
		System.out.println("PessoaMB.listar()");
		return pessoas;
	}

	public void busca(Integer id) {
		System.out.println("PessoaMB.busca()");
		System.out.println("[id=" + id + "]");
		this.pessoa = new PessoaRepository().buscaPorId(id);
	}

}
