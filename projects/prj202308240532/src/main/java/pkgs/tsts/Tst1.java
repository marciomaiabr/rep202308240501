package pkgs.tsts;

import java.lang.reflect.Method;

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

}
