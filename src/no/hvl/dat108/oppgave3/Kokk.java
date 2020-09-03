package no.hvl.dat108.oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread {
	BlockingQueue<Integer> burgerKo;
	public int maksAntBurgere = 5;
	int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(2000, 6000);
	public int burger = 1;

	public Kokk(BlockingQueue<Integer> enKo) {
		this.burgerKo = enKo;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(tilfeldigSekunder);
			} catch (InterruptedException e) {
			}
			
			// Kokken venter når listen er full
			while (burgerKo.size() == maksAntBurgere) {
				System.out.println("###" + Thread.currentThread().getName()
						+ " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
				try {
					Thread.sleep(tilfeldigSekunder);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				burgerKo.put(burger);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// skriver ut en melding
			System.out.println(Thread.currentThread().getName() + " legger på " + "hamburger (" + burger + ")" + " => "
					+ burgerKo.toString());

			// Øker verdi
			burger++;
		}
	}
}
