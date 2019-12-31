package root.entities.plants;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import root.entities.movable.MovableObjects;
import root.entities.movable.Pea;
import root.entities.zombies.Zombie;
import root.etc.CellsManager;

public class ThreePeaShooter extends PeaShooter {

  public Point stuffShooter = new Point(getBounds().width * 5 / 7, getBounds().height / 8);
  private ArrayList<Integer> lane_indexes = new ArrayList<>(3);
  private Map<Integer, Integer> LoopCounters = new HashMap<>(3);
  private Map<Integer, ArrayList<Pea>> stuffsOnLane = new HashMap<>(3);

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
      lane_indexes.add(0);
      lane_indexes.add(1);
    } else if (getLane() == 4) {
      lane_indexes.add(3);
      lane_indexes.add(4);
    } else {
      lane_indexes.add(getLane() - 1);
      lane_indexes.add(getLane());
      lane_indexes.add(getLane() + 1);
    }

    for (int lane_index : lane_indexes) {
      stuffsOnLane.put(lane_index, new ArrayList<>());
      LoopCounters.put(lane_index, 0);
    }
  }

  public void shoot(int lane_index) {
    Pea p = new Pea(position.x + stuffShooter.x, position.y + stuffShooter.y, CellsManager.lanes[lane_index] + stuffShooter.y);
    Stuffs.add(p);
    stuffsOnLane.get(lane_index).add(p);
  }

  public void dealWithZom(int lane_index) {
    Zombie closestZom = closestZom(zomOnLane(lane_index));
    for (MovableObjects obj : Stuffs) {
      if (obj instanceof Pea) {
        if (closestZom.getX() - obj.getX() < closestZom.getImage().getWidth(null) / 4 && ((Pea) obj).getEndY() - stuffShooter.y == closestZom
            .getY()) {
          ((Pea) obj).hitted = true;
          closestZom.health -= 15; //per pea
        }
      }
    }
  }

  @Override
  public void actions() {
    for (int lane_index : lane_indexes) {
      LoopCounters.put(lane_index, LoopCounters.get(lane_index) + 1);
      stuffsOnLane.get(lane_index).removeIf(pea -> pea.hitted || pea.outOfGame);
      if (!zomOnLane(lane_index).isEmpty()) {
        if (stuffsOnLane.get(lane_index).isEmpty() && LoopCounters.get(lane_index) % 32 == 0) {
          shoot(lane_index);
        }
        dealWithZom(lane_index);
      }
    }
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
