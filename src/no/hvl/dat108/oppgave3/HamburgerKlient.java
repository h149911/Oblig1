package no.hvl.dat108.oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HamburgerKlient {

	public static void main(String[] args) {
		BlockingQueue<Integer> burgerKo = new LinkedBlockingQueue<Integer>();
		
		Thread kokk1 = new Kokk(burgerKo);
		kokk1.setName("Kokk1");
		Thread kokk2 = new Kokk(burgerKo);
		kokk2.setName("Kokk2");
		Thread kokk3 = new Kokk(burgerKo);
		kokk3.setName("Kokk3");
		
		Thread servitor1 = new Servitor(burgerKo);
		servitor1.setName("Servitor1");
		Thread servitor2 = new Servitor(burgerKo);
		servitor2.setName("Servitor2");
		
		kokk1.start();
		servitor1.start();
		kokk2.start();
		kokk3.start();
		servitor2.start();

		
	}

}
