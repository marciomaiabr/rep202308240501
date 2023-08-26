package pkgs.tsts;

import pkgs.daos.PessoaDAO;
import pkgs.models.Endereco;
import pkgs.models.Pessoa;
import pkgs.util.Util;

public class Tst1 {

	public static void main(String[] args) {
		m3();
	}

	private static void m1() {
		System.out.println("Olá mundo...");
	}

	private static void m2() {
		System.out.println("Tst1.m2()");
		Util.testaHibernate();
	}

	private static void m3() {
		System.out.println("Tst1.m3()");
		Util.testaJPA();
	}

	private static void m4() {
		System.out.println("Tst1.m4()");
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("lkj");
		pessoa.setSobreNome("kjh");

		Endereco endereco = new Endereco();
		endereco.setDescEndereco("jhg");

		pessoa.setEndereco(endereco);
		endereco.setPessoa(pessoa);

		if(! new PessoaDAO().salvar(pessoa)) {
			Util.testaJPA();
			new PessoaDAO().salvar(pessoa);
		}
	}

}
