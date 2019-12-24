package root.entities.plants;

import java.awt.*;
import java.util.LinkedList;

import root.entities.Actable;
import root.entities.zombies.Zombie;

public class Lawnmower extends Plant implements Actable {

  private static final int SPEED = 5;
  private boolean move = false;

  public Lawnmower(int x, int y) {
    super(x, y);
  }

  @Override
  public void actions() {
    LinkedList<Zombie> zomOnLane = zomOnLane();
    if (move) {
      position.x += SPEED;
      for (Zombie zombie : zomOnLane) {
        if (zombie.getX() - position.x <= SPEED) {
          zombie.health = 0;
        }
      }
    }
    if (!zomOnLane.isEmpty()) {
      if (closestZom(zomOnLane).getX() == position.x + getImage().getWidth(null)) {
        move = true;
        closestZom(zomOnLane).health = 0;
      }
    }
  }

  @Override
  public Image getImage() {
    if (move) {
      return visualMode.LawnmowerMovingImage;
    } else {
      return visualMode.LawnmowerImage;
    }
  }
}
