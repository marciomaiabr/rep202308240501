package pkgs.managedBeans;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import pkgs.daos.PessoaDAO;
import pkgs.models.Endereco;
import pkgs.models.Pessoa;
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

	@PostConstruct
	public void init() {
		System.out.println("PessoaMB.init()");
		System.out.println("[this.pessoa=" + this.pessoa + "]");

		String cmdBtnSalvar = Util.buscaRequestParameterFormPrincipal("cmdBtnSalvar");

		if (cmdBtnSalvar != null) {
			this.pessoa = new Pessoa();
			this.pessoa.setEndereco(new Endereco());
			this.pessoa.getEndereco().setPessoa(this.pessoa);
		}
	}

	public void salvar() {
		System.out.println("PessoaMB.salvar()");
		System.out.println("[this.pessoa=" + this.pessoa + "]");
		new PessoaDAO().salvar(pessoa);
	}

}
