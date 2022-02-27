package model;

import util.Angle;
import util.Point2D;
import util.Vector2D;

public class VerticalEdge extends Edge{
	
	private static final double RECTANGULAR_ANGLE = 90;

	public VerticalEdge(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);
	}

	public VerticalEdge(Point2D traslate, Point2D traslate2) {
		super(traslate, traslate2);
	}
	
	@Override
	public Angle resultAngle(Angle directionAngle) {
		return Angle.ofDegree(this.angle.getDegrees() - RECTANGULAR_ANGLE );
	}
	
	@Override
	public Edge translate(Vector2D vector) {
		return new VerticalEdge(vector.traslate(this.getP1()),
				vector.traslate(this.getP2()));
	}

}
