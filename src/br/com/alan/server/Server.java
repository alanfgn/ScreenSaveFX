package br.com.alan.server;

import java.net.ServerSocket;
import java.util.List;
import java.util.Vector;

/**
 * <h1>Server</h1>
 * 
 * Responsible for managing processes and observers
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
	 * Show the port the server is listening to and accept the clients
	 * connection
	 * 
	 * @return Nothing
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
	 * Kill server thread and other server processes
	 * 
	 * @return nothing
	 * 
	 * @see br.com.alan.server#killAllProcesses()
	 */
	private void suicide() {
		killAllProcesses();
		Thread.currentThread().interrupt();
	}

	/**
	 * Kill all processes of the server
	 * 
	 * @return nothing
	 */
	public void killAllProcesses() {
		this.processes.forEach(x -> x.interrupt());
	}

	/**
	 * Starts a process in the server
	 * 
	 * @param process ServerProcess for running in the server
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
	 * Add server Observer in the list of observers
	 * 
	 * @param serverObserver 
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
