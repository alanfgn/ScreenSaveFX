package br.com.alan.server;

public class Main {

	public static void main(String[] args) {
		Server server = new Server(args.length > 0 ? Integer.valueOf(args[0]) : 8088);
		new Thread(server).start();
		server.execute(new SenderBinaryRandomMessages(args.length > 1 ? Integer.valueOf(args[1]) : 2000));
	}
}
