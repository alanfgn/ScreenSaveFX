package br.com.alan.server;

import java.io.IOException;

public abstract class ServerObserver {
	
	protected Server server;
	public abstract void update(String message) throws IOException;
}
