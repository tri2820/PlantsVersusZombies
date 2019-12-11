package root.GameMode.Visuals;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ScalingMode extends VisualMode {

  // Set Game dimension based on the background image
  static Image BackgroundImageOriginal = new ImageIcon(BACKGROUND).getImage();
  static double ScaleFactor =
      (double) Toolkit.getDefaultToolkit().getScreenSize().height
          / BackgroundImageOriginal.getHeight(null);
  Dimension GameDim =
      new Dimension(
          (int) (BackgroundImageOriginal.getWidth(null) * ScaleFactor),
          (int) (BackgroundImageOriginal.getHeight(null) * ScaleFactor));

  Image BackgroundImage = getScaledImage(BACKGROUND);
  Image SunFlowerImage = getScaledImage(SUNFLOWER);
  Image PeaShooterImage = getScaledImage(PEASHOOTER);
  Image FreezePeaShooterImage = getScaledImage(FREEZE_PEASHOOTER);
  Image SunImage = getScaledImage(SUN);
  Image PeaImage = getScaledImage(PEA);
  Image FreezePeaImage = getScaledImage(FREEZE_PEA);
  Image NormalZombieImage = getScaledImage(NORMAL_ZOMBIE);
  Image ConeHeadZombieImage = getScaledImage(CONE_HEAD_ZOMBIE);
  Image ShovelImage = getScaledImage(SHOVEL, 0.65);

  ImageIcon ShovelButtonIcon = new ImageIcon(getScaledImage(SHOVEL_BUTTON, 0.65));
  ImageIcon SunFlowerCardIcon = new ImageIcon(getScaledImage(SUNFLOWER_CARD));
  ImageIcon PeaShooterCardIcon = new ImageIcon(getScaledImage(PEASHOOTER_CARD));
  ImageIcon FreezePeaShooterCardIcon = new ImageIcon(getScaledImage(FREEZE_PEASHOOTER_CARD));

  static Image getScaledImage(String path) {
    Image originalImage = new ImageIcon(path).getImage();
    return new ImageIcon(
        originalImage.getScaledInstance(
            (int) (originalImage.getWidth(null) * ScaleFactor),
            (int) (originalImage.getHeight(null) * ScaleFactor),
            Image.SCALE_DEFAULT))
        .getImage();
  }

  static Image getScaledImage(String path, double specialAdjustment) {
    Image originalImage = new ImageIcon(path).getImage();
    return new ImageIcon(
        originalImage.getScaledInstance(
            (int) (originalImage.getWidth(null) * ScaleFactor * specialAdjustment),
            (int) (originalImage.getHeight(null) * ScaleFactor * specialAdjustment),
            Image.SCALE_DEFAULT))
        .getImage();
  }
}
