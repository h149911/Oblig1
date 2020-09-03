package no.hvl.dat108.oppgave2;

public class Kokk extends Thread {

	// Et objekt av klassen rutsjebane som har både leggTilBurger
	// og taBurger.
	static final Rutsjebane rb = new Rutsjebane();
	
	
	@Override
	public synchronized void run() {

		try {
			rb.leggTilBurger();
		} catch (InterruptedException e) {
		}

	}
}
