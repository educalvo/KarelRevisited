package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

public class Mondriaan
{
  public static void main(String[] args) {
    speed(100);
    int nrOfTriangles = random(2,4);
    int nrOfHorizontalSteps = random(0,31);
    int nrOfVerticalSteps = random(0,16);
    
    while (nrOfTriangles > 0) {
    	randomMovement(nrOfHorizontalSteps,nrOfVerticalSteps);
    	drawRectangle(random(8,16),random(4,12));
    	nrOfTriangles--;
    }
  }
  private static void randomMovement(int width, int height) {
	  putStep(height,false);
	  turnRight();
	  putStep(width,false);
	  turnRight();
  }
  public static void drawRectangle(int width, int height) {
	putStep(height,true);
	turnRight();
	putStep(width,true);
	turnRight();
	putStep(height,true);
	turnRight();
	putStep(width,true);
	turnRight();
  }
  private static void putStep(int nrOfSteps, boolean leaveBalls) {
	while ((nrOfSteps > 0) && (!inFrontOfWall())) {
		if (!onBall() && (leaveBalls == true))
			putBall();
		step();
		nrOfSteps--;
	}
  }
}
