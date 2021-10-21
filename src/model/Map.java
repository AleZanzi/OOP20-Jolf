package model;

import java.awt.Dimension;
import java.util.List;

public interface Map {

	Dimension getSize();
	
	List<MapObject> getObjects();

	List<MovingObject> getMovingObjects();
	
	List<Star> getStars();
	
	Ball getBall();
	
}
