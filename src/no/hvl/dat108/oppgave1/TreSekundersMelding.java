package no.hvl.dat108.oppgave1;

public class TreSekundersMelding {

	public static void main(String[] args) throws InterruptedException {

		Thread skrivUtMelding = new MinTraad();
		Thread brukerMelding = new BrukerTraad();
		
		skrivUtMelding.start();
		brukerMelding.start();
		
		skrivUtMelding.join();
		brukerMelding.join();
		
	}

}
