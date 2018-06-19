package br.com.alan.server;

/**
 * <h1>Main</h1>
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-19
 */
public class Main {

	/**
	 * <h1>Main method</h1> Pega os possíveis argumentos para porta e tempo de
	 * intervalo e inicia o server com estes argumentos ou o valor default
	 * porta: 8088 intervalo: 2000 milisegundos
	 * 
	 * @param args
	 *            porta e tempo de intervalo.
	 */
	public static void main(String[] args) {
		Server server = new Server(args.length > 0 ? Integer.valueOf(args[0]) : 8088);
		new Thread(server).start();
		server.execute(new SenderBinaryRandomMessages(args.length > 1 ? Integer.valueOf(args[1]) : 2000));
	}
}
