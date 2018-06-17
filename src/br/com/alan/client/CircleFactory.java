package br.com.alan.client;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleFactory {
	
	public static Circle createDefaultSmallCircle(Rectangle2D primaryScreenBounds) {	
		return createDefaultCircle(primaryScreenBounds, (float) primaryScreenBounds.getHeight() * 0.025f);
	}
	public static Circle createDefaultBigCircle(Rectangle2D primaryScreenBounds) {	
		return createDefaultCircle(primaryScreenBounds, (float) primaryScreenBounds.getHeight() * 0.1f);
	}
	
	public static Circle createDefaultMediumCircle(Rectangle2D primaryScreenBounds) {	
		return createDefaultCircle(primaryScreenBounds, (float) primaryScreenBounds.getHeight() * 0.05f);
	}
	
	public static Circle createDefaultCircle(Rectangle2D primaryScreenBounds, float radius) {
		return createDefaultCircle((float) primaryScreenBounds.getHeight() / 2f,
				(float) (primaryScreenBounds.getMinY() - (radius * 2f)), radius);
	}

	public static Circle createDefaultCircle(float centerX, float centerY, float radius) {
		return createCircle(centerX, centerY, radius, Color.WHITE, 20);
	}

	public static Circle createCircle(float centerX, float centerY, float radius, Color color, float strokeWidth) {
		Circle circle = new Circle();
		circle.setCenterX(centerX);
		circle.setCenterY(centerY);
		circle.setRadius(radius);
		circle.setFill(color);
		circle.setStrokeWidth(strokeWidth);
		return circle;

	}
}
