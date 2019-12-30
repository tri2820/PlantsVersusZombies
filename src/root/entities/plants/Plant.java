package root.entities.plants;

import java.awt.Point;
import java.util.LinkedList;
import root.entities.Actable;
import root.entities.GameEntity;
import root.entities.movable.MovableObjects;
import root.entities.zombies.Zombie;
import root.etc.CellsManager;

public abstract class Plant extends GameEntity implements Actable {

  public int price;
  public int health;
  public LinkedList<MovableObjects> Stuffs = new LinkedList<>();
  public Point stuffShooter = new Point(getBounds().width * 5 / 7, getBounds().height / 10);

  public Plant(int x, int y) {
    super(x, y);
  }

  private int getLane() {
    for (int i = 0; i < CellsManager.lanes.length; i++) {
      if (position.y == CellsManager.lanes[i]) {
        return i;
      }
    }
    return 0;
  }

  public LinkedList<Zombie> zomOnLane() {
    LinkedList<Zombie> ZomOnLane = new LinkedList<>();
    for (Zombie zombie : gamePanel.level.zombies) {
      if (zombie.getX() > position.x && zombie.getX() <= visualMode.GameDim.width && position.y == zombie.getY()) {
        ZomOnLane.add(zombie);
      }
    }
    return ZomOnLane;
  }

  public LinkedList<Zombie> zomOnLane(int lane) {
    LinkedList<Zombie> ZomOnLane = new LinkedList<>();
    for (Zombie zombie : gamePanel.level.zombies) {
      if (zombie.getX() > position.x && zombie.getX() <= visualMode.GameDim.width && CellsManager.lanes[lane] == zombie.getY()) {
        ZomOnLane.add(zombie);
      }
    }
    return ZomOnLane;
  }

  public Zombie closestZom(LinkedList<Zombie> ZomOnLane) {
    Zombie closestZomOnLane = ZomOnLane.getFirst();
    for (Zombie zombie : ZomOnLane) {
      if (zombie.getX() < closestZomOnLane.getX()) {
        closestZomOnLane = zombie;
      }
    }

    return closestZomOnLane;
  }

  public int adjustX() {
    return 0;
  }

  public int adjustY() {
    return 0;
  }

}
