package minimalRemake.Plants;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import minimalRemake.Base.Commons;
import minimalRemake.Base.GameEntities;

public class Sun extends GameEntities {
  Random random = new Random();
  int dx = 1;
  int dy = 1;

  public Sun() {
    genPos();
    genDir();
  }

  public Sun(int x, int y) {
    super(x, y);
    genDir();
  }

  private void genPos() {
    position =
        new Point(random.nextInt(Commons.GameDim.width), random.nextInt(Commons.GameDim.height));
  }

  private void genDir() {
    dx = random.nextInt(5) - 2;
    dy = random.nextInt(5) - 2;
  }

  @Override
  public void actions() {
    position.x += dx;
    position.y += dy;
    if (position.x < -100
        || position.y < -100
        || position.x > Commons.GameDim.width + 100
        || position.y > Commons.GameDim.height + 100) {
      genPos();
      genDir();
    }
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(
        position.x, position.y, getImage().getWidth(null), getImage().getHeight(null));
  }

  @Override
  public Image getImage() {
    return Commons.Sun;
  }
}
