package br.com.alan.client;

public enum BezierCurves {
	easeInSine(0.47f, 0f, 0.745f, 0.715f), 
	easeInOutSine(0.445f, 0.05f, 0.55f, 0.95f),
	easeInOutCirc(0.785f, 0.135f, 0.15f, 0.86f);
	
	private float controlX1, controlY1, controlX2, controlY2;

	private BezierCurves(float controlX1, float controlY1, float controlX2, float controlY2) {
		this.controlX1 = controlX1;
		this.controlY1 = controlY1;
		this.controlX2 = controlX2;
		this.controlY2 = controlY2;
	}

	public float getControlX1() {
		return controlX1;
	}

	public float getControlY1() {
		return controlY1;
	}

	public float getControlX2() {
		return controlX2;
	}

	public float getControlY2() {
		return controlY2;
	}

}
