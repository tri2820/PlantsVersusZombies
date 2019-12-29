package root.entities.movable;

import java.awt.Image;

public class Pea extends MovableObjects {

  public boolean hitted = false;
  public boolean outOfGame = false;


  public Pea(int x, int y) {
    super(x, y);
    dx = 20;
    dy = 0;
  }

  @Override
  public void actions() {
    move();

    if (position.x > visualMode.GameDim.getWidth()) {
      outOfGame = true;
    }
  }

  @Override
  public Image getImage() {
    return visualMode.PeaImage;
  }
}
