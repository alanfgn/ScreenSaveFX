package br.com.alan.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * <h1>Client</h1>
 * 
 * Responsável por manter a conexão com o cliente
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-18
 */
public class Client extends ServerObserver {

	private Socket socket;

	public Client(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
		this.server.attach(this);
	}

	/**
	 * Pega o PrintStream do socket para a conexão
	 * 
	 * @return PrintStream Esse é o PrintStream do OutPutStream do Cliente
	 * @throws IOException
	 *             Para erros do socket
	 */
	public PrintStream getClientPrintStream() throws IOException {
		return new PrintStream(socket.getOutputStream());
	}

	/**
	 * Implementação do metodo abstract do ServerOberver 
	 * para enviar uma mensagem para o cliente
	 * 
	 * @see br.com.alan.server.ServerObserver#update(java.lang.String)
	 */
	@Override
	public synchronized void update(String message) throws IOException {
		this.getClientPrintStream().println(message);
		this.getClientPrintStream().flush();
	}

}
