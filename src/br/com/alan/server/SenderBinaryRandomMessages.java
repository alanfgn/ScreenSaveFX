package br.com.alan.server;

import java.io.IOException;
import java.util.Random;

public class SenderBinaryRandomMessages extends ServerRunnable {

	private int interval;
	public Random random = new Random();
	
	public SenderBinaryRandomMessages(int interval) {
		super();
		this.interval = interval;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int size = this.server.getObservers().size();
				if (size > 0)
					this.server.getObservers().get(random.nextInt(size)).update(String.valueOf(interval));
				Thread.sleep(interval);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
