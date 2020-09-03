package no.hvl.dat108.oppgave2.copy;

import java.util.LinkedList;

public class HamburgerKlient {

	public static void main(String[] args) throws InterruptedException {
		LinkedList<Integer> burgerKo = new LinkedList<>();

		// Oppretter flere kokk-tråd
		Thread kokk1 = new Kokk(burgerKo);
		kokk1.setName("Kokk1");
		Thread kokk2 = new Kokk(burgerKo);
		kokk2.setName("Kokk2");
		Thread kokk3 = new Kokk(burgerKo);
		kokk3.setName("Kokk3");

		// Oppretter flere servitør-tråd
		Thread servitor1 = new Servitor(burgerKo);
		servitor1.setName("Servitor1");
		Thread servitor2 = new Servitor(burgerKo);
		servitor2.setName("Servitor2");

		// starter begge trådene
		kokk1.start();
		servitor1.start();
		kokk2.start();
		kokk3.start();
		servitor2.start();

		kokk1.join();
		servitor1.join();
		kokk2.join();
		kokk3.join();
		servitor2.join();

	}

}
