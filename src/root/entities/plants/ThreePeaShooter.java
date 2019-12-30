package root.entities.plants;

import java.awt.Image;
import java.util.ArrayList;
import root.entities.movable.MovableObjects;
import root.entities.movable.Pea;
import root.entities.zombies.Zombie;
import root.etc.CellsManager;

public class ThreePeaShooter extends PeaShooter {

  private ArrayList<Integer> lanes = new ArrayList<>(3);

  public ThreePeaShooter(int x, int y) {
    super(x, y);
    setLanes();
    price = 375;
    health = 200;
  }


  private int getLane() {
    for (int i = 0; i < CellsManager.lanes.length; i++) {
      if (position.y == CellsManager.lanes[i]) {
        return i;
      }
    }
    return 0;
  }

  private void setLanes() {
    if (getLane() == 0) {
      lanes.add(0);
      lanes.add(1);
    } else if (getLane() == 4) {
      lanes.add(3);
      lanes.add(4);
    } else {
      lanes.add(getLane() - 1);
      lanes.add(getLane());
      lanes.add(getLane() + 1);
    }
  }

  public void shoot(int lane) {
    Stuffs.add(new Pea(position.x + stuffShooter.x, CellsManager.lanes[lane] + stuffShooter.y, position.y + stuffShooter.y));
  }

  @Override
  public void dealWithZom() {
    for (int lane : lanes) {
      Zombie closestZom = closestZom(zomOnLane(lane));
      for (MovableObjects movableObjects : Stuffs) {
        if (closestZom.getX() - movableObjects.getX() < closestZom.getImage().getWidth(null) / 4) {
          ((Pea) movableObjects).hitted = true;
          closestZom.health -= 15; //per pea
        }
      }
    }
  }

  public void shoot() {
    lanes.forEach(lane -> shoot(lane));
  }

  @Override
  public int adjustX() {
    return -10;
  }

  @Override
  public int adjustY() {
    return -20;
  }

  @Override
  public Image getImage() {
    return visualMode.ThreePeaShooterImage;
  }
}
