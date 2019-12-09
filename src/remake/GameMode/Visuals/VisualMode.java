package remake.GameMode.Visuals;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import remake.etc.Constants;

public abstract class VisualMode implements Constants {

  public boolean testMode = false;

  public Image BackgroundImage = new ImageIcon(BACKGROUND).getImage();
  public Image PeaShooterImage = new ImageIcon(FREEZE_PEASHOOTER).getImage();
  public Image SunFlowerImage;
  public Image FreezePeaShooterImage;
  public Image SunImage;
  public Image PeaImage;
  public Image FreezePeaImage;
  public Image NormalZombieImage;
  public Image ConeHeadZombieImage;
  public Image ShovelImage;
  public Image ShovelButtonImage;
  public Image LawnmowerImage;

  public ImageIcon ShovelButtonIcon;
  public ImageIcon SunFlowerCardIcon;
  public ImageIcon PeaShooterCardIcon;
  public ImageIcon FreezePeaShooterCardIcon;

  public Dimension GameDim = new Dimension(BackgroundImage.getWidth(null), BackgroundImage.getHeight(null));
  public Dimension cellSize = new Dimension(PeaShooterImage.getWidth(null), PeaShooterImage.getHeight(null));
}
