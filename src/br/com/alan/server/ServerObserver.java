package br.com.alan.server;

import java.io.IOException;

/**
 * <h1>Server Observer</h1>
 * 
 * Classe abstrata para implementa��o do padr�o observer
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-06-18
 */
public abstract class ServerObserver {

	protected Server server;

	/**
	 * Metodo para possibilitar o envio de mensagens para todos observadores
	 * 
	 * @param message
	 *            Mensagem que a implemta��o ir� decidir o que fazer
	 * @throws IOException
	 *            Para erros de conex�o do socket
	 */
	public abstract void update(String message) throws IOException;
}
