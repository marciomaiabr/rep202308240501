package pkgs.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
public class DatabaseMB {

	public DatabaseMB() {
		System.out.println("DatabaseMB.DatabaseMB()");
	}

	public void createDatabase() {
		System.out.println("DatabaseMB.createDatabase()");
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("myPUCreate");
			em = emf.createEntityManager();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
