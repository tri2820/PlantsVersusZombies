package root.entities.movable;

import java.awt.Image;

public class Pea extends MovableObjects {

  public boolean hitted = false;
  private int startY;
  public boolean outOfGame = false;


  public Pea(int x, int y) {
    super(x, y);
    startY = position.y;
    dx = 20;
    dy = 0;
  }

  public Pea(int x, int y, int startY) {
    super(x, y);
    this.startY = startY;
    dx = 20;
    if (y > startY) {
      dy = 1;
    } else {
      dy = -1;
    }
  }

  @Override
  public void actions() {
    move();

    if (startY == position.y) {
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
