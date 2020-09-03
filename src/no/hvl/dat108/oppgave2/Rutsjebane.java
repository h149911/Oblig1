package no.hvl.dat108.oppgave2;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Rutsjebane {

	// En liste som kokk(legger til) og servitør(tar ut) deler
	LinkedList<Integer> burgerKo = new LinkedList<>();
	int maksAntBurgere = 5;

	// Tilfeldig antall sekunder i millisekunder
	int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(500, 1000);
	
	private Object lock = new Object();

	// Funksjonen som kokk-tråden kaller
	public synchronized void leggTilBurger() throws InterruptedException {
		int burger = 1;

		while (true) {
			// venter tilfeldig antall sekunder, mellom 2 og 6
			Thread.sleep(tilfeldigSekunder);

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

	// funksjonen som servitør-tråden kaller
	public void taBurger() throws InterruptedException {

		while (true) {

			// venter tilfeldig antall sekunder, mellom 2 og 6
			Thread.sleep(tilfeldigSekunder);

			synchronized (this) {

				// Servitøren venter når burgerkøen er tom
				while (burgerKo.size() == 0) {
					try {
						System.out.println("###" + Thread.currentThread().getName()
								+ " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
						wait();
					} catch (InterruptedException e) {
					}
				}

				// Tar første burger som er laget.
				int ta = burgerKo.removeFirst();

				System.out.println(
						Thread.currentThread().getName() + " tar av hamburger (" + ta + ") => " + burgerKo.toString());

				// sier ifra til servitør at nå kan den ta fra kø
				notifyAll();
			}
		}

	}
}
