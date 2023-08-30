package pkgs.managedBeans;

import javax.faces.bean.ManagedBean;

import pkgs.util.JPAUtil;

@ManagedBean
public class DatabaseMB {

	public DatabaseMB() {
		System.out.println("DatabaseMB.DatabaseMB()");
	}

	public void createDatabase() {
		System.out.println("DatabaseMB.createDatabase()");
		JPAUtil.createDatabase();
	}

}
