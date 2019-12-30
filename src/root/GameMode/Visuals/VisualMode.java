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

  public Image BackgroundImage = new ImageIcon(BACKGROUND_DAY).getImage();
  public Image PeaShooterImage = new ImageIcon(SNOW_PEA).getImage();
  public Image SunFlowerImage;
  public Image SnowPeaImage;
  public Image SunImage;
  public Image KillSunImage;
  public Image LuckyBalloonImage;
  public ImageIcon ShovelButtonIcon;
  public ImageIcon SunFlowerCardIcon;
  public ImageIcon PeaShooterCardIcon;
  public ImageIcon SnowPeaCardIcon;
  public ImageIcon ThreePeaShooterCardIcon;
  public Image ThreePeaShooterImage;

  public Image ShovelImage;
  public Image ShovelButtonImage;
  public Image LawnmowerImage;
  public Image LawnmowerMovingImage;

  public Image RepeaterImage;
  public ImageIcon RepeaterCardIcon;

  public Image PeaImage;
  public Image FreezePeaImage;
  public Image MushroomImage;

  public Image PuffShroomImage;
  public ImageIcon PuffShroomCardIcon;

  public Image SunShroomImage;
  public ImageIcon SunShroomCardIcon;

  //normal zombie
  public Image NormalZombieWalkImage;
  public Image NormalZombieEatImage;
  public Image NormalZombieDieImage;
  public Image NormalZombieLostHeadWalkImage;
  public Image NormalZombieLostHeadEatImage;
  public Image[] ZombieDie = new Image[10];

  //cone head zombie
  public Image ConeHeadZombieWalkImage;
  public Image ConeHeadZombieEatImage;

  //bucket head zombie
  public Image BucketHeadZombieWalkImage;
  public Image BucketHeadZombieEatImage;

  //newspaper zombie
  public Image NewspaperZombieImage;
  public Image NewspaperZombieEatImage;
  public Image NewsZombieImage;
  public Image NewsZombieEatImage;
  public Image NewsZombieLostHeadImage;
  public Image NewsZombieLostHeadEatImage;

  //flag zombie
  public Image FlagZombieImage;
  public Image FlagZombieEatImage;
  public Image FlagZombieLostHeadImage;
  public Image FlagZombieLostHeadEatImage;

  public Image Walnut1;
  public Image Walnut2;
  public Image Walnut3;
  public ImageIcon WalnutCardIcon;

  public Dimension GameDim = new Dimension(BackgroundImage.getWidth(null), BackgroundImage.getHeight(null));
  public Dimension cellSize = new Dimension(PeaShooterImage.getWidth(null), PeaShooterImage.getHeight(null));

  public Font SOL_FONT;
  public Font PvZUI_FONT;

  public void initFont() {
    //create the font
    try {
      //create the font to use. Specify the size!
      SOL_FONT = Font.createFont(Font.TRUETYPE_FONT, new File(ResourcesPath.SOL_FONT)).deriveFont(50f);
      PvZUI_FONT = Font.createFont(Font.TRUETYPE_FONT, new File(ResourcesPath.PvZUI_FONT)).deriveFont(50f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(SOL_FONT);
      ge.registerFont(PvZUI_FONT);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }
}
