package no.hvl.dat108.oppgave2.copy;

public class HamburgerKlient {

	public static void main(String[] args) throws InterruptedException {
		
		Kokk kokk1 = new Kokk();
		kokk1.setName("Kokk1");
		kokk1.start();
		
		Servitor servitor1 = new Servitor(kokk1);
		servitor1.setName("Servitor1");
		servitor1.start();
		

	}

}
