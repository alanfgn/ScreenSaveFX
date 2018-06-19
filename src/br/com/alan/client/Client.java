package br.com.alan.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * <h1>Client</h1>
 * 
 * Responsavel por manter a conexao com o servidor
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-18
 */
public class Client {

	private int port;
	private String host;
	private Socket socket;

	public Client(int port, String host) {
		super();
		this.port = port;
		this.host = host;
	}

	/**
	 * Retorna o InputStream para escutar o servidor
	 * 
	 * @return InputStream retorna o InputStream do servidor
	 * @throws IOException
	 *             Para erros de conecção vindos do socket
	 */
	public InputStream getServerInputStream() throws IOException {
		return this.socket.getInputStream();
	}

	/**
	 * Exibe o host e a porta que irá se conectar, e se conecta com o servidor
	 * 
	 */
	public void connnect() {
		try {
			System.out.println("::::: Client :::::");
			System.out.println("host: " + host);
			System.out.println("port: " + port);
			this.socket = new Socket(this.host, this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
