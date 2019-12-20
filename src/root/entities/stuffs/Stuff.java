package root.entities.stuffs;

import root.entities.GameEntity;

public abstract class Stuff extends GameEntity {

  public Stuff(int x, int y) {
    super(x, y);
  }

  public Stuff() {
    super();
  }

  public void move() {
    position.x += dx;
    position.y += dy;
  }
}
