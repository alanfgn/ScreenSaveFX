package br.com.alan.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
	
	private int port;
	private String host;
	private Socket socket;

	public Client(int port, String host) {
		super();
		this.port = port;
		this.host = host;
	}
	
	public InputStream getServerInputStream() throws IOException {
		return this.socket.getInputStream();
	}

	public void connnect(){
		try {
			System.out.println("::::: Client :::::");
			System.out.println("host: "+host);
			System.out.println("port: "+port);
			this.socket = new Socket(this.host, this.port);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
