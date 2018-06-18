package br.com.alan.server;

import java.io.IOException;

/**
 * <h1>Server Observer</h1>
 * 
 * Abstract class for the implementation of the Observer pattern
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-06-18
 */
public abstract class ServerObserver {

	protected Server server;

	/**
	 * Send a message for the client
	 * 
	 * @param message
	 *            message that will be sent to the client
	 * @exeption throws IOException
	 */
	public abstract void update(String message) throws IOException;
}
