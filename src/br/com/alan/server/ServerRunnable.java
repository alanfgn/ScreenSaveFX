package br.com.alan.server;

public abstract class ServerRunnable implements Runnable{
	
	protected Server server;
	
	public void setServer(Server server) {
		this.server = server;
	}

}
