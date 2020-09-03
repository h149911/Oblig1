package no.hvl.dat108.oppgave2.copy;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread {

	public int maksAntBurgere = 5;
	int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(2000, 6000);
	public int burger = 1;
	private LinkedList<Integer> burgerKo;

	public Kokk(LinkedList<Integer> enKo) {
		this.burgerKo = enKo;
	}

	@Override
	public void run() {

		while (true) {
			// venter tilfeldig antall sekunder, mellom 2 og 6

			try {
				Thread.sleep(tilfeldigSekunder);
			} catch (InterruptedException e1) {
			}
			synchronized (this) {
				// Kokken venter når listen er full
				while (burgerKo.size() == maksAntBurgere) {
					try {
						System.out.println("###" + Thread.currentThread().getName()
								+ " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
						wait();
					} catch (InterruptedException e) {
					}
				}

				// Legger til burger
				burgerKo.add(burger);

				// skriver ut en melding
				System.out.println(Thread.currentThread().getName() + " legger på " + "hamburger (" + burger + ")"
						+ " => " + burgerKo.toString());

				// Øker verdi
				burger++;

				// sier ifra til servitør at nå kan den ta fra kø
				notifyAll();
			}
		}
	}
}
