package pkgs.repositorys;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Repositorys {

	public Repositorys() {
		System.out.println("Repositorys.Repositorys()");
	}

	public static Repository getRepository() {
		System.out.println("Repositorys.getRepository()");
		return new PessoaRepositoryJPA();
	}
	
}
