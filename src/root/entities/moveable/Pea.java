package root.entities.moveable;

import java.awt.*;

public class Pea extends MoveableObjects {

  public boolean hitted = false;
  public boolean outOfGame = false;


  public Pea(int x, int y) {
    super(x, y);
    dx = 10;
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
