package no.hvl.dat108.oppgave2;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Rutsjebane {
	
	// En liste som kokk(legger til) og servitør(tar ut) deler
	LinkedList<Integer> burgerKo = new LinkedList<>();
	int maksAntBurgere = 5;
	
	// Tilfeldig antall sekunder i millisekunder
	int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(500, 2000);
	
	// Funksjonen som kokk-tråden kaller
	public synchronized void leggTilBurger() throws InterruptedException {
		int verdi = 1;

		while (true) {
			// Kokken venter når listen er full
			while (burgerKo.size() == maksAntBurgere) {
				System.out.println("###" + Thread.currentThread().getName()
						+ " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
			wait();
			}
			
			burgerKo.add(verdi);

			System.out.println(Thread.currentThread().getName() + " legger på " + "hamburger (" + verdi + ")" + " => "
					+ burgerKo.toString());

			verdi++;

			// sier ifra til servitør at nå kan den ta fra kø
			notifyAll();

			// Tilfeldig sleeping mellom 2 og 6 sekunder.
			Thread.sleep(tilfeldigSekunder);
		}
	}

	// funksjonen som servitør-tråden kaller
	public synchronized void taBurger() throws InterruptedException {

		while (true) {
			// Servitøren venter når burgerkøen er tom
			while (burgerKo.size() == 0) {
				System.out.println("###" + Thread.currentThread().getName()
						+ " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
			wait();
			}
			// Tar første burger som er laget.
			int ta = burgerKo.removeFirst();

			System.out.println(Thread.currentThread().getName() + " tar av hamburger (" + ta + ") => " +
								burgerKo.toString());

			// Vekker kokke-tråden
			notifyAll();

			// og venter tilfeldig antall sekunder, mellom 2 og 6
			Thread.sleep(tilfeldigSekunder);
		}
	}
}
