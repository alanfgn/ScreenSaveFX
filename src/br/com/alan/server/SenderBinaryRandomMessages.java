package br.com.alan.server;

import java.io.IOException;
import java.util.Random;

/**
 * <h1>Sender Binary Random Messages</h1>
 * 
 * Runnable Server Process that sends the time interval of the animation to
 * random clients
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-18
 * @see br.com.alan.server.ServerRunnable
 */
public class SenderBinaryRandomMessages extends ServerRunnable {

	private int interval;
	public Random random = new Random();

	public SenderBinaryRandomMessages(int interval) {
		super();
		this.interval = interval;
	}

	/**
	 * Implementation of the method run of Runnable Send the time interval of
	 * the animation to random clients
	 * 
	 * @see java.lang.Runnable#run()
	 */
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
