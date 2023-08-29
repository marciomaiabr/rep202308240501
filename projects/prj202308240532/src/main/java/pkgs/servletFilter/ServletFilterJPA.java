package pkgs.servletFilter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames={"Faces Servlet"})
public class ServletFilterJPA implements Filter {

	public ServletFilterJPA() {
		System.out.println("ServletFilterJPA.ServletFilterJPA()");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("ServletFilterJPA.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ServletFilterJPA.doFilter()");

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("myPUNoCreate");
			entityManager = entityManagerFactory.createEntityManager();

			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			request.setAttribute("entityManager", entityManager);

			chain.doFilter(request, response);

			entityTransaction.commit();
		} catch (Exception e) {
			try {
				entityTransaction.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		} finally {
			try {
				entityManager.close();
			} catch (Exception e) {
			}
			try {
				entityManagerFactory.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void destroy() {
		System.out.println("ServletFilterJPA.destroy()");
	}

}