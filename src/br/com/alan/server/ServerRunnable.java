package br.com.alan.server;

/**
 * <h1>Server Runnable</h1>
 *
 * Abstract implementation of Runnable for the processes that will run on the
 * server
 * 
 * @author 	Alan
 * @version 1.0
 * @since 	2018-06-18
 * @see 	java.lang.Runnable
 */
public abstract class ServerRunnable implements Runnable {

	protected Server server;

	public void setServer(Server server) {
		this.server = server;
	}

}
