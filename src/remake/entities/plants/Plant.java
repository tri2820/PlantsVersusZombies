package remake.entities.plants;

import java.awt.Point;
import java.util.LinkedList;
import remake.entities.GameEntity;
import remake.entities.stuffs.Stuff;

public abstract class Plant extends GameEntity {

  public int price;
  public int health;
  public LinkedList<Stuff> stuffs = new LinkedList<>();
  public Point stuffShooter = new Point(getBounds().width * 5 / 7, getBounds().height / 10);

  public Plant(int x, int y) {
    super(x, y);
  }
}
