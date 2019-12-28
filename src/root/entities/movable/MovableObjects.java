package root.entities.movable;

import root.entities.Actable;
import root.entities.GameEntity;

public abstract class MovableObjects extends GameEntity implements Actable {

  public MovableObjects(int x, int y) {
    super(x, y);
  }

  public void move() {
    position.x += dx;
    position.y += dy;
  }
}
