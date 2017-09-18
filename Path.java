package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

public class Path {
	public static void main(String[] args) {
		map("path.map");
		speed(50);
		followPath();
	}

	private static void followPath() {
		while (!inFrontOfWall()) {
			step();
			if (!onBall()) {
				turnAround();
				checkSides();
			} else
				followPath();
		}
		checkSides();
	}

	private static void checkFinal() {
		System.out.println("final");
		
/*		turnLeft();
		if (!inFrontOfWall()) {
			step();
			if (!onBall()) {
				turnAround();
			} else {
				System.out.println("test");
			}
		} else {
			turnAround();
			if (!onBall()) {
				turnAround();
				step();
			}
		}
*/	}

	private static void checkSides() {
		turnLeft();
		if (!inFrontOfWall()) {
			step();
			if (onBall()) {
				followPath();
			} else {
				turnAround();
				step();
				checkFinal();
			}
		} else {
			turnAround();
			if (!onBall()) {
				turnAround();
				step();
			} else {
				followPath();
			}
		}
	}

	private static void turnAround() {
		turnLeft();
		turnLeft();
		step();

	}
}
