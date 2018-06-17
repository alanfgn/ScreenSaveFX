package br.com.alan.client;

import java.util.Scanner;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FxScreen extends Application {

	private static String host = "0.0.0.0";
	private static int port = 8088;

	@Override
	public void start(Stage stage) throws Exception {
		Client client = new Client(port, host);
		client.connnect();
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		Circle circle = CircleFactory.createDefaultMediumCircle(primaryScreenBounds);
		
		Group root = new Group(circle);
		Scene scene = new Scene(root, 500, 500, Color.rgb(0, 33, 71));
		
		stage.setTitle("Screensave");
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				Scanner sc = new Scanner(client.getServerInputStream());
				while (sc.hasNextLine()) {
					CirclePathTransitionFactory.createDeaultPathTransition(circle, Integer.valueOf(sc.nextLine()),
							primaryScreenBounds).play();
				}
				sc.close();
				return null;
			}
		};

		Thread t = new Thread(task);
		t.setDaemon(true);
		t.start();

	}

	public static void main(String args[]) {
		if (args.length > 0)
			host = args[0];
		if (args.length > 1)
			port = Integer.valueOf(args[1]);

		launch(args);
	}

}
