package pkgs.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import pkgs.converts.EnderecoConverter;
import pkgs.models.AreaAtuacao;
import pkgs.models.Endereco;
import pkgs.models.Pessoa;
import pkgs.services.PessoaService;
import pkgs.util.JSFUtil;

@ManagedBean
public class PessoaMB {

	public PessoaMB() {
		System.out.println("PessoaMB.PessoaMB()");
	}

	@ManagedProperty("#{param['idPrincipal']}")
	private Integer idPrincipal;

	public Integer getIdPrincipal() {
		return idPrincipal;
	}

	public void setIdPrincipal(Integer idPrincipal) {
		System.out.println("PessoaMB.setIdPrincipal()");
		System.out.println("[this.idPrincipal=" + this.idPrincipal + "]");
		System.out.println("[idPrincipal=" + idPrincipal + "]");
		this.idPrincipal = idPrincipal;
	}

	@ManagedProperty("#{pessoaService}")
	private PessoaService pessoaService;

	public PessoaService getPessoaService() {
		System.out.println("PessoaMB.getPessoaService()");
		System.out.println("[this.pessoaService=" + this.pessoaService + "]");
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		System.out.println("PessoaMB.setPessoaService()");
		System.out.println("[this.pessoaService=" + this.pessoaService + "][pessoaService=" + pessoaService + "]");
		this.pessoaService = pessoaService;
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

	private EnderecoConverter enderecoConverter = new EnderecoConverter();
	public void setEnderecoConverter(EnderecoConverter enderecoConverter) {
		this.enderecoConverter = enderecoConverter;
	}
	public EnderecoConverter getEnderecoConverter() {
		return enderecoConverter;
	}

	@PostConstruct
	public void init() {
		System.out.println("PessoaMB.init()");
		System.out.println("[this.pessoa=" + this.pessoa + "]");
		System.out.println("[this.pessoaService=" + this.pessoaService + "]");
		System.out.println("[this.idPrincipal=" + this.idPrincipal + "]");

		String cmdBtnSalvar = JSFUtil.buscaRequestParameterFormPrincipal("cmdBtnSalvar");

		if ((this.idPrincipal != null) && (!this.idPrincipal.equals(0))) {
			System.out.println("if 1...");
			this.pessoa = pessoaService.buscaPorId(idPrincipal);
		} else {
			System.out.println("else 1...");
			if (cmdBtnSalvar != null) {
				System.out.println("if 1...");
				this.pessoa = new Pessoa();
				// this.pessoa.setEndereco(new Endereco());
				// this.pessoa.getEndereco().setPessoa(this.pessoa);
			}
		}

		System.out.println("[this.pessoa=" + this.pessoa + "]");
	}

	public String salvar() {
		System.out.println("PessoaMB.salvar()");
		System.out.println("[this.pessoa=" + this.pessoa + "]");
		System.out.println("[this.pessoa.getEndereco()=" + this.pessoa.getEndereco() + "]");
		this.pessoa.getEndereco().setPessoa(this.pessoa);
		System.out.println("[this.pessoaService=" + this.pessoaService + "]");
		System.out.println("[this.idPrincipal=" + this.idPrincipal + "]");

		pessoaService.salvar(pessoa);
		return "listar";
	}

	public void pesquisar() {
		pessoas = pessoaService.listar();
	}

	public List<Pessoa> listar() {
		System.out.println("PessoaMB.listar()");
		return pessoas;
	}

	public List<AreaAtuacao> getAreasAtuacao() {
		System.out.println("PessoaMB.getAreasAtuacao()");
		return pessoaService.listarAreasAtuacao();
	}

}
