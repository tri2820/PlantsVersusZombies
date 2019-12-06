package PvZ.GameMode;

import PvZ.Base.Directories;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class VisualMode implements Directories {

  public boolean testMode = false;

  public Image BackgroundImage;
  public Image SunFlowerImage;
  public Image PeaShooterImage;
  public Image FreezePeaShooterImage;
  public Image SunImage;
  public Image PeaImage;
  public Image FreezePeaImage;
  public Image NormalZombieImage;
  public Image ConeHeadZombieImage;
  public Image ShovelImage;
  public Image ShovelButtonImage;

  public ImageIcon ShovelButtonIcon;
  public ImageIcon SunFlowerCardIcon;
  public ImageIcon PeaShooterCardIcon;
  public ImageIcon FreezePeaShooterCardIcon;

  public Dimension GameDim;
}
