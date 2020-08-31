package no.hvl.dat108.oppgave1;

import javax.swing.JOptionPane;

public class BrukerTraad extends Thread {
	
	private boolean fortsett = true;
	
	@Override
	public void run() {
		synchronized (this) {
			while (fortsett) {
				String dineOrd = JOptionPane.showInputDialog("Skriv inn ord, quit for å avslutte: ");
				if (dineOrd == null || ("quit".equals(dineOrd))) {
					System.exit(0);
				}
				System.out.println(dineOrd);
				notify();
			}
		}

	}

}
