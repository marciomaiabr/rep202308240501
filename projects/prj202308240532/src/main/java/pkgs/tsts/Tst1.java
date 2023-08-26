package pkgs.tsts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import pkgs.daos.PessoaDAO;
import pkgs.models.Endereco;
import pkgs.models.Pessoa;
import pkgs.util.Util;

public class Tst1 {

	public static void main(String[] args) {
		try {
			// System.out.println("Digite o Id do método que deseja executar:");
			// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// String valorDigitado = reader.readLine();
			String valorDigitado = javax.swing.JOptionPane.showInputDialog("Digite o Id do método que deseja executar:");
			System.out.println("[valorDigitado="+valorDigitado+"]");
			if(valorDigitado==null) {
				System.out.println("Operação cancelada...");
			}else {
				Method[] methods = Tst1.class.getMethods();
				Method method = null;
				for(Method m : methods) {
					if(m.getName().equals("m".concat(valorDigitado)))
						method = m;
				}
				if(method==null) {
					System.out.println("Método não encontrado...");
				}else {
					System.out.println("[method="+method+"]");
					method.invoke(null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void m1() {
		System.out.println("Olá mundo...");
	}

	public static void m2() {
		System.out.println("Tst1.m2()");
		Util.testaHibernate();
	}

	public static void m3() {
		System.out.println("Tst1.m3()");
		Util.testaJPA();
	}

	public static void m4() {
		System.out.println("Tst1.m4()");
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("lkj");
		pessoa.setSobreNome("kjh");

		Endereco endereco = new Endereco();
		endereco.setDescEndereco("jhg");

		pessoa.setEndereco(endereco);
		endereco.setPessoa(pessoa);

		if (!new PessoaDAO().salvar(pessoa)) {
			Util.testaJPA();
			new PessoaDAO().salvar(pessoa);
		}
	}

}
