package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		final hasID winner = new hasID(-1);
		Random random = new Random();
		Robot[] robots = new Robot[5];
		int[] startX = new int[robots.length];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot(125 * i + 275, 900);
			startX[i] = robots[i].getX();
		}
		
		Thread[] threads = new Thread[robots.length];
		for (int i = 0; i < threads.length; i++) {
			final int I = i;
			threads[i] = new Thread(() -> {
				Robot robot = robots[I];
				for (robot.turn(-90); robot.getX() >  200;) robot.move(random.nextInt(2));
				for (robot.turn( 90); robot.getY() >  200;) robot.move(random.nextInt(2));
				for (robot.turn( 90); robot.getX() < 1300;) robot.move(random.nextInt(2));
				for (robot.turn( 90); robot.getY() <  900;) robot.move(random.nextInt(2));
				for (robot.turn( 90); robot.getX() > startX[I];) robot.move(random.nextInt(2));
				robot.turn( 90);
				if (winner.ID == -1) {
					winner.ID = I;
					System.out.println("Robot " + (winner.ID + 1) + " won!");
				}
			});
		}
		
		for (Thread thread : threads) {
			thread.start();
		}
	}
	
	static class hasID {
		int ID;
		hasID (int ID) {
			this.ID = ID;
		}
	}
}