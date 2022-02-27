package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import util.Point2D;

public class IronWall implements MapObject {
	private final Point2D position;
	private static final Color IRONWALL_COLOR = new Color(192, 192, 192);
	private final int width;
	private final int height;
	private final Set<Edge> edges;
	
	/**
	 * @param position
	 * @param width
	 * @param height
	 */
	public IronWall(final Point2D position, final int width, final int height) {
		this.position = position;
		this.width = width;
		this.height = height;
		final Point2D p1 = this.position;
		final Point2D p2 = new Point2D(this.position.getX() + width - 1, this.position.getY());
		final Point2D p3 = new Point2D(this.position.getX() + width - 1, this.position.getY() + height - 1);
		final Point2D p4 = new Point2D(this.position.getX(), this.position.getY() + height - 1);
		edges = Set.of(new Edge(p1, p2),
				new Edge(p2, p3),
				new Edge(p3, p4),
				new Edge(p4, p1));
	}

	@Override
	public Point2D getPosition() {
		return this.position;
	}

	@Override
	public void draw(final Graphics g) {
		g.setColor(IRONWALL_COLOR);
		g.fillRect(this.position.getIntX(), this.position.getIntY(), this.width, this.height);
		g.setColor(Color.BLACK);
		edges.forEach(edge -> g.drawLine(edge.getP1().getIntX(), 
				edge.getP1().getIntY(), 
				edge.getP2().getIntX(), 
				edge.getP2().getIntY()));
	}

	@Override
	public void applyConstraintTo(final Ball ball) {
		edges.stream().forEach(edge -> edge.applyConstraintTo(ball));
	}
	
	/*
	private static final Color IRONWALL_COLOR = new Color(192, 192, 192);
	 
	public IronWall(final Point2D position, final int width, final int height) {
		super(position, width, height);
	}

	@Override
	public void draw(final Graphics g) {
		g.setColor(IRONWALL_COLOR);
		g.fillRect(this.getPosition().getIntX(), this.getPosition().getIntY(), this.width, this.height);
		g.setColor(Color.BLACK);
		edges.forEach(edge -> g.drawLine(edge.getP1().getIntX(), 
				edge.getP1().getIntY(), 
				edge.getP2().getIntX(), 
				edge.getP2().getIntY()));
	}

	@Override
	public void applyConstraintTo(final Ball ball) {
		//Inserire tipologia collisioni
	}
	*/
}