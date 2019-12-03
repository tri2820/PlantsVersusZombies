package remake.plants;

import components.Interfaces.Shoot;
import entities.Base.Plant;
import helper.Dir;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FreezePeaShooter {
  Image i = new ImageIcon(Dir.resource + "plants/freezepeashooter.gif").getImage();
  int heath = 100;
  int damage = 10;
}
