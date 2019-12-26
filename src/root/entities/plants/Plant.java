package root.entities.plants;

import java.awt.Point;
import java.util.LinkedList;

import root.entities.Actable;
import root.entities.GameEntity;
import root.entities.moveable.MoveableObjects;
import root.entities.zombies.Zombie;

public abstract class Plant extends GameEntity implements Actable {

  public int price;
  public int health;
  public LinkedList<MoveableObjects> moveableEntities = new LinkedList<>();
  public Point stuffShooter = new Point(getBounds().width * 5 / 7, getBounds().height / 10);

  public Plant(int x, int y) {
    super(x, y);
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

  public Zombie closestZom(LinkedList<Zombie> ZomOnLane) {
    Zombie closestZomOnLane = ZomOnLane.getFirst();
    for (Zombie zombie : ZomOnLane) {
      if (zombie.getX() < closestZomOnLane.getX()) {
        closestZomOnLane = zombie;
      }
    }

    return closestZomOnLane;
  }

//  @Override
//  public void actions() {
//    LoopCounter++;
//    if (!zomOnLane().isEmpty()) {
//      if (moveableEntities.isEmpty() && LoopCounter % 20 == 0) {
//        shoot();
//      }
//      dealWithZom();
//    }
//  }
}
