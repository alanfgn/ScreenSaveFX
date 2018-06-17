package br.com.alan.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends ServerObserver{

	private Socket socket;
	
	public Client(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
		this.server.attach(this);
	}
	
	public PrintStream getClientPrintStream() throws IOException {
		return new PrintStream(socket.getOutputStream());
	}
	
	@Override
	public synchronized void update(String message) throws IOException {
		this.getClientPrintStream().println(message);
		this.getClientPrintStream().flush();
	}

}
