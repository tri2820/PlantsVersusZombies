package root.GameMode.Visuals;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import root.etc.ResourcesPath;

public abstract class VisualMode implements ResourcesPath {

  public boolean testMode = false;

  public Image BackgroundImage = new ImageIcon(BACKGROUND).getImage();
  public Image PeaShooterImage = new ImageIcon(FREEZE_PEASHOOTER).getImage();
  public Image SunFlowerImage;
  public Image FreezePeaShooterImage;
  public Image SunImage;
  public Image KillSunImage;

  public Image RepeaterImage;
  public ImageIcon RepeaterCardIcon;

  public Image PeaImage;
  public Image FreezePeaImage;
  public Image NormalZombieWalkImage;
  public Image NormalZombieEatImage;
  public Image NormalZombieLostHeadWalkImage;
  public Image NormalZombieLostHeadEatImage;

  public Image ConeHeadZombieWalkImage;
  public Image ConeHeadZombieEatImage;

  public Image ShovelImage;
  public Image ShovelButtonImage;
  public Image LawnmowerImage;
  public Image LawnmowerMovingImage;

  public ImageIcon ShovelButtonIcon;
  public ImageIcon SunFlowerCardIcon;
  public ImageIcon PeaShooterCardIcon;
  public ImageIcon FreezePeaShooterCardIcon;

  public Image Walnut1;
  public Image Walnut2;
  public Image Walnut3;
  public ImageIcon WalnutCardIcon;

  public Dimension GameDim = new Dimension(BackgroundImage.getWidth(null), BackgroundImage.getHeight(null));
  public Dimension cellSize = new Dimension(PeaShooterImage.getWidth(null), PeaShooterImage.getHeight(null));

  public Font SOL_FONT;

  public void initFont() {
    //create the font
    try {
      //create the font to use. Specify the size!
      SOL_FONT = Font.createFont(Font.TRUETYPE_FONT, new File(ResourcesPath.SOL_FONT)).deriveFont(50f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(SOL_FONT);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }
}
