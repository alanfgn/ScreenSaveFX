package br.com.alan.server;

import java.net.ServerSocket;
import java.util.List;
import java.util.Vector;

/**
 * <h1>Server</h1>
 * 
 * Reponsável por gerenciar o clientes e processos
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-18
 */
public class Server implements Runnable {

	private int port;
	private ServerSocket serverSocket;
	private List<ServerObserver> observers = new Vector<>();
	private List<Thread> processes = new Vector<>();

	public Server(int port) {
		this.port = port;
	}

	/**
	 * Exibe a porta que esta executando e aceita conexões de clientes
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			this.serverSocket = new ServerSocket(port);

			System.out.println("::::: Server :::::");
			System.out.println("port: " + port);

			while (true) {
				new Client(serverSocket.accept(), this);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.suicide();
		}
	}

	/**
	 * Mata sua própria Thread e os outros processos alocados no servidor
	 * 
	 * @see br.com.alan.server#killAllProcesses()
	 */
	private void suicide() {
		killAllProcesses();
		Thread.currentThread().interrupt();
	}

	/**
	 * Mata todos os processos alocados no servidor
	 */
	public void killAllProcesses() {
		this.processes.forEach(x -> x.interrupt());
	}

	/**
	 * Executa um processo no servidor
	 * 
	 * @param process
	 *            ServerProcess para rodar no servidor
	 * 
	 * @see br.com.alan.server.ServerRunnable
	 */
	public synchronized void execute(ServerRunnable process) {
		process.setServer(this);
		Thread thread = new Thread(process);
		thread.start();
		this.processes.add(thread);
	}

	/**
	 * Adiciona um ServerObserver para lista de clientes do servidor
	 * 
	 * @param serverObserver
	 *            ServerObserver para adicionar como cliente do servidor
	 * @see br.com.alan.server.ServerObserver
	 */
	public synchronized void attach(ServerObserver serverObserver) {
		this.observers.add(serverObserver);
	}

	public List<ServerObserver> getObservers() {
		return observers;
	}

	public List<Thread> getProcesses() {
		return processes;
	}
}
