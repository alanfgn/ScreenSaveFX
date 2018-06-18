package br.com.alan.server;

public class Main {

	/**
	 * <h1>Main method</h1> This is the main method which makes start Server.
	 * 
	 * @param args
	 *            Unused.
	 * @return Nothing.
	 * @exception IOException
	 *                On input error.
	 * @see IOException
	 */

	public static void main(String[] args) {
		Server server = new Server(args.length > 0 ? Integer.valueOf(args[0]) : 8088);
		new Thread(server).start();
		server.execute(new SenderBinaryRandomMessages(args.length > 1 ? Integer.valueOf(args[1]) : 2000));
	}
}
