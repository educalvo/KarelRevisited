package nl.ru.ai.p4ai.exercise2;

import static nl.ru.ai.karel.Karel.*;

public class CatchThemAll
{

  public static void main(String[] args)
  {
	  map("pokemap.map");
	  speed(50);
	  while (!east())
		  turnRight();
	  while (getNumberOfPokemon() < 5) {
		  checkSpot();
		  while (!inFrontOfWall()) {
			  step();
			  checkSpot();
		  }
		  turnAround();
	  }
  }
  private static void turnAround() {
	  if ((west() == true) && (inFrontOfWall())) {
		  turnRight();
		  step();
		  checkSpot();
		  turnRight();
	  }
	  if ((east() == true) && (inFrontOfWall())) {
		  turnLeft();
		  step();
		  checkSpot();
		  turnLeft();
	  }
  }
  private static void checkSpot() {
	  if (onBall())
		  getBall();
	  if (onPokemon() && (getNumberOfBalls() > 0))
		  getPokemon();
  }
}
