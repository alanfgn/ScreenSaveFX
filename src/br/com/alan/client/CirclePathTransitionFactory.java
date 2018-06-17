package br.com.alan.client;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class CirclePathTransitionFactory {
	
	public static PathTransition createDeaultPathTransition(Circle circle, int duration,
			Rectangle2D primaryScreenBounds) {
		return createDeaultPathTransition(circle, duration, primaryScreenBounds, BezierCurves.easeInOutCirc);
	}
	
	public static PathTransition createDeaultPathTransition(Circle circle, int duration,
			Rectangle2D primaryScreenBounds, BezierCurves curve) {

		float circleDiameter = (float) (circle.getRadius() * 2f);

		float middleScreen = (float) (primaryScreenBounds.getHeight() / 2f);
		float beforeScreen = (float) (primaryScreenBounds.getMinX() - circleDiameter);
		float afterScreen = (float) (primaryScreenBounds.getWidth() + circleDiameter);

		float maxX = (float) primaryScreenBounds.getWidth();
		float maxY = (float) primaryScreenBounds.getHeight();

		return createDeaultPathTransition(circle, duration, beforeScreen, middleScreen, (maxX * curve.getControlX1()),
				(maxY * curve.getControlY1()), (maxX * curve.getControlX2()), (maxY * curve.getControlY2()),
				afterScreen, middleScreen);
	}

	public static PathTransition createDeaultPathTransition(Circle circle, int duration, float startX, float startY,
			float controlX1, float controlY1, float controlX2, float controlY2, float x, float y) {
		return createPathTransition(circle, duration, 1, false, OrientationType.ORTHOGONAL_TO_TANGENT, startX, startY,
				controlX1, controlY1, controlX2, controlY2, x, y);
	}

	public static PathTransition createPathTransition(Circle circle, int duration, int cycleQtd, boolean autoReverse,
			OrientationType orientationType, float startX, float startY, float controlX1, float controlY1,
			float controlX2, float controlY2, float x, float y) {
		MoveTo moveTo = new MoveTo(startX, startY);
		CubicCurveTo cubicCurveTo = new CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y);

		Path path = new Path();
		path.getElements().add(moveTo);
		path.getElements().add(cubicCurveTo);

		PathTransition pathTransition = new PathTransition();

		pathTransition.setDuration(Duration.millis(duration));
		pathTransition.setNode(circle);
		pathTransition.setPath(path);

		pathTransition.setOrientation(orientationType);
		pathTransition.setCycleCount(cycleQtd);
		pathTransition.setAutoReverse(autoReverse);

		return pathTransition;
	}

}
