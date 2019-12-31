package root.entities.movable;

import java.awt.Image;

public class Pea extends MovableObjects {

  public boolean hitted = false;
  private int startY, endY;
  public boolean outOfGame = false;

  public Pea(int x, int y) {
    super(x, y);
    startY = position.y;
    endY = position.y;
    dx = 20;
    dy = 0;
  }

  public Pea(int x, int startY, int endY) {
    super(x, startY);
    this.endY = endY;
    dx = 20;
    dy = 10 * Integer.compare(endY, startY);
  }

  public int getEndY() {
    return endY;
  }


  @Override
  public void actions() {
    move();

    if (Math.abs(endY - position.y) <= Math.abs(dy) && dy != 0) {
      dy = 0;
    }

    if (position.x > visualMode.GameDim.getWidth()) {
      outOfGame = true;
    }
  }

  @Override
  public Image getImage() {
    return visualMode.PeaImage;
  }
}
