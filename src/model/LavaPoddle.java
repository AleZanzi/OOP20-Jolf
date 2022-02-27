package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import util.Point2D;

public class LavaPoddle implements MapObject {

	private static final Color LAVA_COLOR = new Color(255, 127, 0);
	private final Point2D position;
	private final int width;
	private final int height;
	private final Rectangle2D hitbox;
	private boolean isLava;
	
	public LavaPoddle(final Point2D position, final int width, final int height) {
		this.position = position;
		this.width = width;
		this.height = height;
		this.hitbox = new Rectangle2D.Double(position.getX(), position.getY(), width, height);
		this.isLava = false;
	}
	
	@Override
	public Point2D getPosition() {
		return this.position;
	}
	
	@Override
	public String toString() {
		return "LavaPoddle [isGameOver=" + isLava + ", hitbox: " + this.hitbox.getBounds().getCenterX() + ", " + this.hitbox.getBounds().getCenterY() + "]";
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(LAVA_COLOR);
		g.fillRect(this.position.getIntX(), this.position.getIntY(), this.width, this.height);
	}
	
	public boolean isLava() {
		return isLava;
	}

	@Override
	public void applyConstraintTo(Ball ball) {
		if (this.hitbox.contains(ball.getPosition().getX(), ball.getPosition().getY())) {
			this.isLava = true;
		}
	}
	

}
