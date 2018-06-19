package br.com.alan.client;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 * <h1>Circle Path Transition Factory</h1>
 * 
 * Fabrica Transicoes de caminho para circulos
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-18
 */
public class CirclePathTransitionFactory {
	
	/**
	 * Retorna a transicao de caminho default ja com a curva de Bezier definida por padrao como easeInOutCirc
	 * 
	 * @param circle Circulo alvo da transição
	 * @param duration Duração da transiçao
	 * @param primaryScreenBounds Retangulo com as informações da tela
	 * @return A Transição com os valores definidos como padrões
	 * @see br.com.alan.client.BezierCurves
	 */
	public static PathTransition createDeaultPathTransition(Circle circle, int duration,
			Rectangle2D primaryScreenBounds) {
		return createDeaultPathTransition(circle, duration, primaryScreenBounds, BezierCurves.easeInOutCirc);
	}
	
	/**
	 * Calcula os pontos da tela para fazer a animaçaõ 
	 * de acordo com a informação da tela e dos valores da curva de bezier
	 * 
	 * @param circle Circulo alvo da transição
	 * @param duration Duração da animação
	 * @param primaryScreenBounds Retangulo com as informações de tamanho da tela
	 * @param curve Enum contendo alguns valores padrões da curva de Bezier para fazer a transição
	 * @return A Transição de caminho default a partir da curva especificada
	 * @see br.com.alan.client.BezierCurves
	 */
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

	/**
	 * Faz uma transição com valores definidos como padrão a partir dos valores X e Y de inicio,
	 *  valores da curva e bezier e valores X e Y finais
	 * 
	 * @param circle Circulo alvo da transição
	 * @param duration Duração da animação
	 * @param startX O ponto X inicial
	 * @param startY O ponto Y inicial
	 * @param controlX1 Valor X1 para formação da curva de bezier
	 * @param controlY1 Valor Y1 para formação da curva de bezier
	 * @param controlX2 Valor X2 para formação da curva de bezier
	 * @param controlY2 Valor Y2 para formação da curva de bezier
	 * @param x O ponto X final
	 * @param y O ponto Y final
	 * @return A Transição de caminho default a partir dos valores especificados
	 */
	public static PathTransition createDeaultPathTransition(Circle circle, int duration, float startX, float startY,
			float controlX1, float controlY1, float controlX2, float controlY2, float x, float y) {
		return createPathTransition(circle, duration, 1, false, OrientationType.ORTHOGONAL_TO_TANGENT, startX, startY,
				controlX1, controlY1, controlX2, controlY2, x, y);
	}
	
	/**
	 * Faz uma Transição de caminho para circulos a partir dos valores especificados
	 * 
	 * @param circle Circulo alvo da transição
	 * @param duration Duração da animação
	 * @param cycleQtd Quantidade de vezes que se repetirá a animação
	 * @param autoReverse Se a animação fará o caminho inverso depois de um ciclo de animação
	 * @param orientationType A orientação do circulo ao longo do caminho
	 * @param startX O ponto X inicial
	 * @param startY O ponto Y inicial
	 * @param controlX1 Valor X1 para formação da curva de bezier
	 * @param controlY1 Valor Y1 para formação da curva de bezier
	 * @param controlX2 Valor X2 para formação da curva de bezier
	 * @param controlY2 Valor Y2 para formação da curva de bezier
	 * @param x O ponto X final
	 * @param y O ponto Y final
	 * @return A transição de caminho a partir dos valores especificados
	 * @see javafx.scene.shape.Circle
	 */
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
