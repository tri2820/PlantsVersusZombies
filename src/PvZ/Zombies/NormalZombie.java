package PvZ.Zombies;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.time.Duration;
import java.time.Instant;

public class NormalZombie extends GameEntities {

  public static Instant startWave;
  public boolean hitted = false;
  int health = 100;
  int damage = 10;
  int dx = level.ZombieSpeed;

  public NormalZombie() {
    startWave = Instant.now();
    position = new Point(visual.GameDim.width + 10, lanes[luck.nextInt(lanes.length)] - visual.GameDim.height / 67);
  }

  public NormalZombie(int x, int y) {
    startWave = Instant.now();
    position = new Point(x, y);
  }

  @Override
  public void actions() {
    long delay = Duration.between(startWave, Instant.now()).toMillis();
    if (delay % level.delayTimeBtwZombies < 100) {
      if (!visible) {
        visible = luck.nextInt(300) == 50;
      }
      System.out.println(visible);
      System.out.println("Zombie out");
    }
    if (visible) {
      position.x += dx;
    }
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return visual.NormalZombieImage;
  }
}
