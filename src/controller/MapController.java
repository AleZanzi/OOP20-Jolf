package controller;
import java.util.Optional;

import model.LavaPoddle;
import model.Map;
import model.MapImpl;
import model.MovingObject;
import model.Star;
import util.Vector2D;
import view.GameInput;
import view.GameOutput;

/**
 * Simulates a game of Jolf of a single map
 * @author loren
 *
 */
public class MapController extends Thread implements Controller {

	private final static long DELAY = 30l;
	private final static int MAX_SPEED = 150;
	private final static int MAX_SQUARE_SPEED = MAX_SPEED * MAX_SPEED;
	
	private GameOutput myOutput;
	private GameInput myInput;
	private final Map map;
	
	private boolean playing = false;
	private boolean holeCreated = false;
	private int currentShots;
	
	/**
	 * @param m
	 */
	public MapController(final Map m) {
		this.map = m;
	}
	
	public MapController(final String mapName) {
		this(MapImpl.getMap(mapName));
	}
	
	@Override
	public void run() {
		try {
			while (playing) {
				if (!this.map.getBall().isMoving()) {
					this.myInput.enableShot(this.map.getBall().getPosition().toPoint());
				}
				if (this.holeCreated && this.map.getStars().stream().anyMatch(Star::isGameOver)) {
					this.playing = false;
					this.myOutput.gameFinished(this.currentShots);
				}
				if(this.map.getLavaPoddles().stream().anyMatch(LavaPoddle::isLava)){
					this.playing = false;
					this.currentShots += 10;
					this.myOutput.gameLost(this.currentShots);
				}
				if (!this.holeCreated && this.map.getStars().stream().filter(Star::isVisible).count() == 1) {
					this.map.getStars().stream().filter(Star::isVisible).findFirst().ifPresent(Star::becomeHole);
					this.holeCreated = true;
				}
				myOutput.updateObjectsPosition(this.map.getObjects(), this.map.getStars());
				Thread.sleep(DELAY);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start() {
		this.currentShots = 0;
		this.myOutput.setSize(this.map.getSize());
		this.myOutput.updateShotCount(this.currentShots);
		this.playing = true;
		this.map.getMovingObjects().stream().forEach(MovingObject::start);
		super.start();
	}
	
	@Override
	public void forceStop() {
		this.playing = false;
		this.map.getMovingObjects().forEach(MovingObject::forceStop);
	}
	
	@Override
	public void newShot(Vector2D shot) { 
		this.map.getBall().setSpeed(shot.getSquareModule() > MAX_SQUARE_SPEED ?
				new Vector2D(shot.getAngle(), MAX_SPEED) : 
				shot);
		this.currentShots++;
		this.myOutput.updateShotCount(this.currentShots);
	}

	@Override
	public void setInput(GameInput inputView) {
		this.myInput = inputView;
	}

	@Override
	public void setOutput(GameOutput outputView) {
		this.myOutput = outputView;
	}

	@Override
	public Optional<String> getPlayerName() {
		return Optional.empty();
	}

	@Override
	public String getMapName() {
		return this.map.getName();
	}

}
