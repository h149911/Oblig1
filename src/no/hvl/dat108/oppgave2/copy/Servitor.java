package no.hvl.dat108.oppgave2.copy;

import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {
	
	private Kokk kokk;
	private int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(500, 2000);
	
	public Servitor (Kokk kokk) {
		this.kokk = kokk;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				kokk.taBurger();
				sleep(tilfeldigSekunder);
			}
		} catch (Exception exp) {
		}
	}
	
}
