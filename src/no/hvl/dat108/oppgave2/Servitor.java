package no.hvl.dat108.oppgave2;

public class Servitor extends Thread {
	
	// Et objekt av klassen SettInOgTaUt som har både leggTilBurger
	// og taBurger.

	@Override
	public synchronized void run() {
		
		try {
			Kokk.rb.taBurger();
		} catch (InterruptedException e) {
		}
	}

}
