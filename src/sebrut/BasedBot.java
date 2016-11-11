package sebrut;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * BasedBot - a robot by sebrut
 */
public class BasedBot extends Robot
{
    /**
     * run: BasedBot's default behavior
     */
    public void run() {
	setColors(Color.red,Color.blue,Color.green); // body,gun,radar

	// Robot main loop
	while(true) {
	    ahead(100);
	    setAdjustRadarForGunTurn(true);
	    turnRadarRight(45);
	    turnRight(15);
	}
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
	// Replace the next line with any behavior you would like
	fireAtAngle(e.getBearing(), e.getDistance());
	turnRadarLeft(30);
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
	// Replace the next line with any behavior you would like
	back(50);
    }

    public void onHitRobot(HitRobotEvent e) {
	fireAtAngle(e.getBearing(), 0);

	if(getEnergy() > e.getEnergy()) {
	    turnRight(e.getBearing());
	    back(50);
	    ahead(50);
	} else {
	    back(100);
	    turnRight(180);
	}
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
	// Replace the next line with any behavior you would like
	back(20);
	turnRight(100);
    }

    public void fireAtAngle(double bearing) {
	fireAtAngle(bearing, 1200);
    }
    public void fireAtAngle(double bearing, double distance) {
	turnGunRight(bearing);
	fire(1200/distance);
	turnGunLeft(bearing);
    }	
}
