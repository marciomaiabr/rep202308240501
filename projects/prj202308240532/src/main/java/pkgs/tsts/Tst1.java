package pkgs.tsts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pkgs.models.ObjetoX;
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

}
