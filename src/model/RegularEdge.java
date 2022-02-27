package model;

import util.Angle;
import util.Point2D;
import util.Vector2D;

public class RegularEdge extends Edge {

	public RegularEdge(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);
	}

	public RegularEdge(Point2D traslate, Point2D traslate2) {
		super(traslate, traslate2);
	}
	
	@Override
	public Angle resultAngle(Angle directionAngle) {
		return Angle.ofRadians(this.angle.getRadians() * 2 - directionAngle.getRadians());
	}

	@Override
	public Edge translate(Vector2D vector) {
		return new RegularEdge(vector.traslate(this.getP1()),
				vector.traslate(this.getP2()));
	}

}
