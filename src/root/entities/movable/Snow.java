package root.entities.movable;

import java.awt.Image;

public class Snow extends Pea {

  public Snow(int x, int y) {
    super(x, y);
  }

  @Override
  public Image getImage() {
    return visualMode.FreezePeaImage;
  }
}
