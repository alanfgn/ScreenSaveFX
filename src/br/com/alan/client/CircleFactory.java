package br.com.alan.client;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * <h1>Circle Factory</h1>
 * 
 * Fabrica Transições de circulos
 * 
 * @author Alan
 * @version 1.0
 * @since 2018-05-18
 */
public class CircleFactory {
	
	/**
	 * Faz um circulo padrão pequeno de acordo com a tela
	 * 
	 * @param primaryScreenBounds Retangulo com as informações da tela
	 * @return Circulo pequeno de acordo com a tela
	 */
	public static Circle createDefaultSmallCircle(Rectangle2D primaryScreenBounds) {	
		return createDefaultCircle(primaryScreenBounds, (float) primaryScreenBounds.getHeight() * 0.025f);
	}
	
	
	/**
	 * Faz um circulo padrão grande de acordo com a tela
	 * 
	 * @param primaryScreenBounds Retangulo com as informações da tela
	 * @return Circulo grande de acordo com a tela
	 */
	public static Circle createDefaultBigCircle(Rectangle2D primaryScreenBounds) {	
		return createDefaultCircle(primaryScreenBounds, (float) primaryScreenBounds.getHeight() * 0.1f);
	}
	
	
	/**
	 * Faz um circulo padrão médio de acordo com a tela
	 * 
	 * @param primaryScreenBounds Retangulo com as informações da tela
	 * @return Circulo médio de acordo com a tela
	 */
	public static Circle createDefaultMediumCircle(Rectangle2D primaryScreenBounds) {	
		return createDefaultCircle(primaryScreenBounds, (float) primaryScreenBounds.getHeight() * 0.05f);
	}
	
	/**
	 * Faz um circulo padrão
	 * 
	 * @param primaryScreenBounds Retangulo com as informações da tela
	 * @param radius o tamanho do circulo
	 * @return O Circulo padrão
	 */
	public static Circle createDefaultCircle(Rectangle2D primaryScreenBounds, float radius) {
		return createDefaultCircle((float) primaryScreenBounds.getHeight() / 2f,
				(float) (primaryScreenBounds.getMinY() - (radius * 2f)), radius);
	}

	/**
	 * Faz um circulo padrão de acordo com o tamnho e local na tela
	 * 
	 * @param centerX Local do circulo segundo o eixo X
	 * @param centerY Local do circulo segundo o eixo Y
	 * @param radius Tamanho do raio do circulo
	 * @return O Circulo padrão de acordo com os valores especificados
	 */
	public static Circle createDefaultCircle(float centerX, float centerY, float radius) {
		return createCircle(centerX, centerY, radius, Color.WHITE, 0);
	}

	/**
	 * Faz um circulo
	 * 
	 * @param centerX Local do circulo segundo o eixo X
	 * @param centerY Local do circulo segundo o eixo Y
	 * @param radius Tamanho do raio do circulo
	 * @param color Cor do circulo
	 * @param strokeWidth Tamanho da borda do circulo
	 * @return Um Circulo
	 */
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
