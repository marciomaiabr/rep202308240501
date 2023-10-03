package pkgs.tsts;

import java.lang.reflect.Method;

import pkgs.models.AreaAtuacao;
import pkgs.models.Endereco;
import pkgs.models.Pessoa;
import pkgs.repositorys.PessoaRepositoryJPA;
import pkgs.util.HibernateUtil;
import pkgs.util.JPAUtil;

public class Tst1 {

	public static void main(String[] args) {
		try {
			// System.out.println("Digite o Id do método que deseja executar:");
			// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// String valorDigitado = reader.readLine();
			String valorDigitado = javax.swing.JOptionPane
					.showInputDialog("Digite o Id do método que deseja executar:");
			System.out.println("[valorDigitado=" + valorDigitado + "]");
			if (valorDigitado == null) {
				System.out.println("Operação cancelada...");
			} else {
				Method[] methods = Tst1.class.getMethods();
				Method method = null;
				for (Method m : methods) {
					if (m.getName().equals("m".concat(valorDigitado)))
						method = m;
				}
				if (method == null) {
					System.out.println("Método não encontrado...");
				} else {
					System.out.println("[method=" + method + "]");
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
		HibernateUtil.testaHibernate();
	}

	public static void m3() {
		System.out.println("Tst1.m3()");
		JPAUtil.testaJPA();
	}

	public static void m5() {
		System.out.println("Tst1.m5()");
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("lkj");
		pessoa.setSobreNome("kjh");

		Endereco endereco = new Endereco();
		//endereco.setDescEndereco("jhg");

		pessoa.setEndereco(endereco);
		endereco.setPessoa(pessoa);

		JPAUtil.execute(entityManager -> {
			System.out.println("Tst1.m5()... JPAUtil.execute()... 1...");
			Pessoa p = entityManager.merge(pessoa);
			pessoa.setId(p.getId());
			pessoa.getEndereco().setId(p.getEndereco().getId());
		});

		JPAUtil.execute(entityManager -> {
			System.out.println("Tst1.m5()... JPAUtil.execute()... 2...");
			Pessoa p = entityManager.find(Pessoa.class, pessoa.getId());
			System.out.println("[p=" + p + "]");
			Endereco e = entityManager.find(Endereco.class, pessoa.getEndereco().getId());
			System.out.println("[e=" + e + "]");
		});

	}

	public static void m6() {
		System.out.println("Tst1.m6()");
		JPAUtil.createDatabase();
		JPAUtil.initialInsert();
	}

	public static void m7() {
		System.out.println("Tst1.m7()");

		JPAUtil.execute(entityManager -> {
			System.out.println("Tst1.m7()... JPAUtil.execute()... 1...");
			AreaAtuacao areaAtuacao = null;
			//areaAtuacao = entityManager.find(AreaAtuacao.class, 1);
			areaAtuacao = entityManager.createQuery(" select aa from AreaAtuacao aa ", AreaAtuacao.class).getResultList().get(0);
			//areaAtuacao = entityManager.createQuery(" select aa from AreaAtuacao aa join fetch aa.subAreaAtuacao ", AreaAtuacao.class).getResultList().get(0);
			System.out.println("[areaAtuacao="+areaAtuacao+"]");
		});
	}

}
