package br.com.alan.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/*
 * <h1> Client </h1>
 * 
 * Class Client, part of the implementation of the observer pattern 
 * responsible for maintaining connection to a client
 * 
 * @author 	Alan
 * @version 1.0
 * @since	2018-05-18
 */
public class Client extends ServerObserver{

	private Socket socket;
	
	public Client(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
		this.server.attach(this);
	}
	
	/*
	 * gets the printStream of the socket for the conncection
	 * 
	 * @return  PrintStream This PrintStream is the OutPutStream of the Client connected
	 * @exeption IOException
	 */
	public PrintStream getClientPrintStream() throws IOException {
		return new PrintStream(socket.getOutputStream());
	}
	
	/*
	 * Implementation of the abstract method of the ServerObserver
	 * 
	 * @see br.com.alan.server.ServerObserver#update(java.lang.String)
	 */
	@Override
	public synchronized void update(String message) throws IOException {
		this.getClientPrintStream().println(message);
		this.getClientPrintStream().flush();
	}

}
