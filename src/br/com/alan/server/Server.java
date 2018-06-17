package br.com.alan.server;

import java.net.ServerSocket;
import java.util.List;
import java.util.Vector;

public class Server implements Runnable{
	
	private int port;
	private ServerSocket serverSocket;
	private List<ServerObserver> observers = new Vector<>();
	private List<Thread> processes = new Vector<>();
	
	public Server(int port) {
		this.port = port;
	}
	
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
	
	private void suicide() {
		killAllProcesses();
		Thread.currentThread().interrupt();	
	}
	
	public void killAllProcesses() {
		this.processes.forEach(x -> x.interrupt());
	}
	
	public synchronized void execute(ServerRunnable process) {
		process.setServer(this);
		Thread thread = new Thread(process);
		thread.start();
		this.processes.add(thread);
	}
	
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
