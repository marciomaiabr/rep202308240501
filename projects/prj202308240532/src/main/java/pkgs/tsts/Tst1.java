package pkgs.tsts;

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
