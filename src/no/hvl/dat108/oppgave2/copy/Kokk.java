package no.hvl.dat108.oppgave2.copy;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread {

	private int tilfeldigSekunder = ThreadLocalRandom.current().nextInt(500, 2000);
	private static final int MAKS_ANTALL = 5;
	private final LinkedList<Integer> burgerKo = new LinkedList<>();
	
	@Override
	public void run() {
		try {
			while (true) {
				lagBurger();
				sleep(tilfeldigSekunder);
			}
		} catch (Exception exp) {
		}
	}
	
	public synchronized void lagBurger() throws InterruptedException {
		int verdi = 1;
		while (burgerKo.size() == MAKS_ANTALL) {
			System.out.println("###" + Thread.currentThread().getName()
					+ " er klar med en burger, men rutsjebanen er full." +
					" Venter! ###");
			wait();
		}
		burgerKo.add(verdi);
		System.out.println(Thread.currentThread().getName() + " legger på "
				   + "hamburger (" + verdi + ")" + burgerKo.toString());
		burgerKo.add(verdi++);
		notifyAll();
		Thread.sleep(tilfeldigSekunder);
	}
	
	public synchronized void taBurger() throws InterruptedException {
		while (burgerKo.size() == 0) {
			System.out.println("###" + Thread.currentThread().getName()
					+ " vil ta en hamburger, men rutsjebanen er tom." +
					" Venter! ###");
			wait();
		}
		int tar = burgerKo.removeFirst();
		System.out.println(Thread.currentThread().getName() + " tar av "
				   + "hamburger (" + tar + ")" + 
				   " => [(" + burgerKo.toString() + ")]");
		notifyAll();
		Thread.sleep(tilfeldigSekunder);
	}
	
}
