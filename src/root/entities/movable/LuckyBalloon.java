package root.entities.movable;

import java.awt.Image;
import java.util.Random;
import root.entities.zombies.Zombie.Effects;
import root.etc.CellsManager;

public class LuckyBalloon extends MovableObjects {

  public static final int existLoop = 100;
  private static final int bound = 20;
  private static Random luck = new Random();
  public boolean clicked = false;

  public LuckyBalloon(int x, int y) {
    super(x, y);
    generateMove();
  }

  private void generateMove() {
    dx = luck.nextInt(bound) - bound * 1.0 / 2;
    dy = luck.nextInt(bound) - bound * 1.0 / 2;
  }

  @Override
  public void actions() {
    LoopCounter++;
    position.x += dx;
    position.y += dy;
    if (position.x <= 0 || position.x + getImage().getWidth(null) >= visualMode.GameDim.width) {
      dx *= -1;
      dy = luck.nextInt(bound) - bound * 1.0 / 2;
    } else if (position.y <= 0
        || position.y + getImage().getHeight(null) >= visualMode.GameDim.height) {
      dy *= -1;
      dx = luck.nextInt(bound) - bound * 1.0 / 2;
    }
  }

  public void luckyEffect() {
    int opt = luck.nextInt(7);
    switch (opt) {
      case 0:
        Sun.updateCount(Sun.Count);
        break;
      case 1:
        int tmp = Sun.Count;
        Sun.Count = 0;
        Sun.updateCount(tmp / 2);
        break;
      case 2:
        Sun.updateCount(1000);
        break;
      case 3:
        CellsManager.cellMaps.forEach(CellsManager.cellMaps::remove);
        break;
      case 4:
        gamePanel.level.zombies.forEach(zombie -> {
          zombie.specialEffect = true;
          zombie.effects = Effects.BACKWARD;
        });
        break;
      case 5:
        gamePanel.level.zombies.forEach(zombie -> {
          zombie.specialEffect = true;
          zombie.effects = Effects.BOOST;
        });
        break;
      case 6:
        int bad_number = luck.nextInt(CellsManager.lanes.length);
        CellsManager.cellMaps.forEach((point, plant) -> {
          if (point.y == CellsManager.lanes[bad_number]) {
            CellsManager.cellMaps.remove(point);
          }
        });
        break;
    }

    clicked = true;
  }

  @Override
  public Image getImage() {
    return visualMode.LuckyBalloonImage;
  }
}
