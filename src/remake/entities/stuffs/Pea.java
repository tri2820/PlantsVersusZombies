package remake.entities.stuffs;

import java.awt.Image;

public class Pea extends Stuff {

  public boolean hitted = false;
  public boolean outOfGame = false;


  public Pea(int x, int y) {
    super(x, y);
    dx = visualMode.GameDim.width / 200;
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
