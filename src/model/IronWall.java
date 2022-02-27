package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import util.Point2D;

public class IronWall extends Wall {
	
	private static final Color IRONWALL_COLOR = new Color(192, 192, 192);
	 
	public IronWall(final Point2D position, final int width, final int height) {
		super(position, width, height);
	}

	@Override
	public void draw(final Graphics g) {
		g.setColor(IRONWALL_COLOR);
		super.draw(g);
	}

	@Override
	protected Set<Edge> setEdges(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
		return Set.of(new VerticalEdge(p1, p2),
				new VerticalEdge(p2, p3),
				new VerticalEdge(p3, p4),
				new VerticalEdge(p4, p1));
	}

}
