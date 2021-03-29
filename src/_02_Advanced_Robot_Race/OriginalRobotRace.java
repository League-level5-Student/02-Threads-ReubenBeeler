package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

import java.lang.Thread;

public class OriginalRobotRace {
	//1. make a main method
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		int winner = 0;
		//2. create an array of 5 robots.
		Robot[] robotArray = new Robot[5];
		//3. use a for loop to initialize the robots.
		for (int i = 0; i < robotArray.length; i++) {
			//4. make each robot start at the bottom of the screen, side by side, facing up
			robotArray[i] = new Robot(125 * i + 75, 550);}
		//5. use another for loop to iterate through the array and make each robot move 
	    //   a random amount less than 50. ...
		//6. use a while loop to repeat step 5 until a robot has reached the top of the screen.
		
		/*
		 * Comment replaced by Step 9
		 * 
		boolean finish = false;
		while (!finish) {
	    	for (Robot robot : robotArray) {robot.moveTo(robot.getX(), robot.getY() - random.nextInt(50));}
	    	for (int i = 0; i < robotArray.length; i++) {if (robotArray[i].getY() <= 0) {winner = i + 1; finish = true;}}
		}
		*/
		
		//7. declare that robot the winner and throw it a party!
		System.out.print("Robot " + winner + " WON!!!");
		//8. try different races with different amounts of robots.
    	//   No thanks!
	    //9. make the robots race around a circular track.
		
		boolean[][] boolBoolArray = {{true, false, false, false}, {true, false, false, false}, {true, false, false, false}, {true, false, false, false}, {true, false, false, false}};
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < robotArray.length; j++) {
				Robot robot = robotArray[j];
				if (boolBoolArray[j][0] && robot.getX() >= 100) {robot.moveTo(robot.getX() - random.nextInt(50), robot.getY());} else {boolBoolArray[j][0] = false; if (!checkArray(boolBoolArray[j])) {boolBoolArray[j][1] = true;}}
				if (boolBoolArray[j][1] && robot.getY() >= 100) {robot.moveTo(robot.getX(), robot.getY() - random.nextInt(50));} else {boolBoolArray[j][1] = false; if (!checkArray(boolBoolArray[j])) {boolBoolArray[j][2] = true;}}
				if (boolBoolArray[j][2] && robot.getX() <= 600) {robot.moveTo(robot.getX() + random.nextInt(50), robot.getY());} else {boolBoolArray[j][2] = false; if (!checkArray(boolBoolArray[j])) {boolBoolArray[j][3] = true;}}
				if (boolBoolArray[j][3] && robot.getY() <= 500) {robot.moveTo(robot.getX(), robot.getY() + random.nextInt(50));} else {boolBoolArray[j][3] = false; if (!checkArray(boolBoolArray[j])) {boolBoolArray[j][0] = true;}}
			}	Thread.sleep(100);
		}
	}
	
	static boolean checkArray (boolean[] boolArray) {
		boolean remain = false;
		for (Boolean bool : boolArray) {if (bool == true) {remain = true;}}
		return remain;
	}
	
	/*
	 * 
	 * Use Robot.move(int distance) and Robot.turn(int degrees) methods to make more efficient.
	 * 
	 */
}
