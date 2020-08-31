package no.hvl.dat108.oppgave1;

public class MinTraad extends Thread {
	
	private boolean vent = true;
	
	@Override
	public void run() {
		synchronized (this) {
			while (vent) {
				System.out.println("Hallo Verden!");
				try {
					Thread.sleep(3000);
					wait();
				} catch (InterruptedException e) {
				}
			}

		}
	}
}
