package pkgs.managedBeans;

import javax.faces.bean.ManagedBean;

import pkgs.util.JPAUtil;

@ManagedBean
public class TestaJSFJPAMB {

	public void testaJPA() {
		JPAUtil.testaJPA();
	}

}
