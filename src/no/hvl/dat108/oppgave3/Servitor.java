package no.hvl.dat108.oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {
	private BlockingQueue<Integer> burgerKo;
	int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(2000, 6000);

	public Servitor(BlockingQueue<Integer> enKo) {
		this.burgerKo = enKo;
	}

	@Override
	public void run() {

		while (true) {

			while (burgerKo.size() == 0) {
				System.out.println("###" + Thread.currentThread().getName()
						+ " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
				try {
					Thread.sleep(tilfeldigSekunder);
				} catch (InterruptedException e) {
				}
			}
			try {
				Integer ta = burgerKo.take();
				System.out.println(
						Thread.currentThread().getName() + " tar av hamburger (" + ta + ") => " + burgerKo.toString());
				Thread.sleep(tilfeldigSekunder);
			} catch (InterruptedException e1) {
			}
		}
	}
}
