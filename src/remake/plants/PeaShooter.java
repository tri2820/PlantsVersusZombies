package remake.plants;

import components.Interfaces.Shoot;
import entities.Base.Plant;
import helper.Dir;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PeaShooter {
  Image i = new ImageIcon(Dir.resource + "plants/peashooter.gif").getImage();

  int health = 100;
  int damage = 10;
}
