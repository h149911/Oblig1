package no.hvl.dat108.oppgave2;

public class HamburgerKlient {

	public static void main(String[] args) throws InterruptedException {
		
		// Oppretter flere kokk-tråd
		Thread kokk1 = new Kokk();
		kokk1.setName("Kokk1");
		Thread kokk2 = new Kokk();
		kokk2.setName("Kokk2");
		Thread kokk3 = new Kokk();
		kokk3.setName("Kokk3");

		// Oppretter flere servitør-tråd
		Thread servitor1 = new Servitor();
		servitor1.setName("Servitor1");
		Thread servitor2 = new Servitor();
		servitor2.setName("Servitor2");
		
		// starter begge trådene
		kokk1.start();
		servitor1.start();
		kokk2.start();
		kokk3.start();
		servitor2.start();

	}

}
