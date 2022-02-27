package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import util.Point2D;

public class WoodWall extends Wall {
	
	private static final Color WOODWALL_COLOR = new Color(87, 61, 28);

	public WoodWall(final Point2D position, final int width, final int height) {
		super(position, width, height);
	}

	@Override
	public void draw(final Graphics g) {
		g.setColor(WOODWALL_COLOR);
		super.draw(g);
	}

	@Override
	public Set<Edge> setEdges(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
		return  Set.of(new RegularEdge(p1, p2),
				new RegularEdge(p2, p3),
				new RegularEdge(p3, p4),
				new RegularEdge(p4, p1));
	}
}
