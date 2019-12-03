package remake.plants;

import components.Position;
import entities.Base.Plant;
import helper.Dir;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SunFlower extends Plant {
  private String resourceDir;
  Image i = new ImageIcon(Dir.resource + "plants/sunflower.gif").getImage();
}
