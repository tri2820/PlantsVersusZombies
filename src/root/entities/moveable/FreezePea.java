package root.entities.moveable;

import java.awt.*;

public class FreezePea extends Pea {

  public FreezePea(int x, int y) {
    super(x, y);
  }

  @Override
  public Image getImage() {
    return visualMode.FreezePeaImage;
  }
}
