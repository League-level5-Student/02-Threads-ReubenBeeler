package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	
	
	public static void main(String[] args) {
		
		Robot[] robots = new Robot[5];
		robots[0] = new Robot(600, 350);
		robots[1] = new Robot(800, 350);
		robots[2] = new Robot(1000, 350);
		robots[3] = new Robot(700, 550);
		robots[4] = new Robot(900, 550);
		
		Thread[] threads = new Thread[5];
		for (int i = 0; i < 5; i++) {
			final int I = i;
			robots[i].setSpeed(10);
			threads[i] = new Thread(() -> {
				for (int degrees = 0; degrees < 360; degrees++) {
					robots[I].move(2); 
					robots[I].turn(1);
				}
			});
		}
		
		/*
		 * For drawing with Graphics but I don't know how/where League J-Frame/Panel is used
		 * 
		//ConcurrentLinkedQueue<int[]>[] locations = new ConcurrentLinkedQueue<>();
		int[][][] locations = new int[5][2][2];
		*/
		
		for (Thread thread : threads) {
			thread.start();
		}
	}
}