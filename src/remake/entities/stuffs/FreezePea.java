package remake.entities.stuffs;

import java.awt.Image;

public class FreezePea extends Pea {

  public FreezePea(int x, int y) {
    super(x, y);
  }

  @Override
  public Image getImage() {
    return visualMode.FreezePeaImage;
  }
}
