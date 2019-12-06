package PvZ.Plants;

import PvZ.Base.GameEntities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Sun extends GameEntities {

  public static int Count = 0;
  public static JLabel CountLabel;
  private static Point SunCollector = new Point(GameDim.width / 90, GameDim.height / 67);
  public GameEntities owner = null;
  public boolean collected = false;
  int dx = lv.SunSpeedBoundX;
  int dy = lv.SunSpeedBoundY;
  int SUN_BOUND = 333;
  int SUN_LUCKY_NUM = 33;
  int x_initial = 0;
  int y_initial = 0;
  private boolean wasInvisible = false;

  public Sun() {
    genPos();
    genDir();
  }

  public Sun(int x, int y, GameEntities owner) {
    super(x, y);
    x_initial = x;
    y_initial = y;
    this.owner = owner;
    genDir();
  }

  private void genPos() {
    position = new Point(luck.nextInt(GameDim.width), luck.nextInt(GameDim.height));
  }

  private void genPos(int x, int y) {
    position = new Point(x, y);
    genDir();
  }

  private void genDir() {
    do {
      dx = luck.nextInt(lv.SunSpeedBoundX) - ((lv.SunSpeedBoundX) / 2);
      dy = luck.nextInt(lv.SunSpeedBoundY) - ((lv.SunSpeedBoundY) / 2);
    } while (dx == 0 || dy == 0);
  }

  @Override
  public void actions() {
    position.x += dx;
    position.y += dy;
    if (owner != null) {
      if (owner.visible) {
        if (!visible) {
          wasInvisible = true;
          visible = luck.nextInt(SUN_BOUND) == SUN_LUCKY_NUM;
        }
        if (visible && wasInvisible) {
          genPos(x_initial, y_initial);
          genDir();
          wasInvisible = false;
        }
      } else {
        visible = false;
      }
    } else if (!visible) {
      visible = luck.nextInt(SUN_BOUND) == SUN_LUCKY_NUM;
    }

    if (position.x < -100
        || position.y < -100
        || position.x > GameDim.width + 100
        || position.y > GameDim.height + 100) {
      visible = false;
      if (owner != null) {
        genPos(x_initial, y_initial);
      } else {
        genPos();
      }
      genDir();
    }
    if (collected) {
      double speed = 10;
      double length = SunCollector.distance(position);
      dx = (int) ((SunCollector.x - position.x) / length * speed);
      dy = (int) ((SunCollector.y - position.y) / length * speed);
      if (Math.abs(SunCollector.x - position.x) < 20
          && Math.abs(SunCollector.y - position.y) < 20) {
        visible = false;
        collected = false;
        CountLabel.setText(String.valueOf(Count += 25));
      }
    }
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(
        position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return SunImage;
  }
}
