package root.entities.stuffs;

import root.entities.Actable;
import root.entities.GameEntity;

public abstract class MoveableEntity extends GameEntity implements Actable {

  public MoveableEntity(int x, int y) {
    super(x, y);
  }

  public void move() {
    position.x += dx;
    position.y += dy;
  }
}
