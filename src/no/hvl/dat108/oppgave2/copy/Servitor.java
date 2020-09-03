package no.hvl.dat108.oppgave2.copy;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {

	// Et objekt av klassen SettInOgTaUt som har både leggTilBurger
	// og taBurger.
	private LinkedList<Integer> burgerKo;
	int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(2000, 6000);

	public Servitor(LinkedList<Integer> enKo) {
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
				// Servitøren venter når burgerkøen er tom
				while (burgerKo.size() == 0) {
					try {
						System.out.println("###" + Thread.currentThread().getName()
								+ " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
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
