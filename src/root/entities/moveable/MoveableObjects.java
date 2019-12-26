package root.entities.moveable;

import root.entities.Actable;
import root.entities.GameEntity;

public abstract class MoveableObjects extends GameEntity implements Actable {

  public MoveableObjects(int x, int y) {
    super(x, y);
  }

  public void move() {
    position.x += dx;
    position.y += dy;
  }
}
