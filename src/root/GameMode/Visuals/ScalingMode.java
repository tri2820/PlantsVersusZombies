package root.GameMode.Visuals;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ScalingMode extends VisualMode {

  // Set Game dimension based on the background image
  static Image BackgroundImageOriginal = new ImageIcon(BACKGROUND_DAY).getImage();
  static double ScaleFactor =
      (double) Toolkit.getDefaultToolkit().getScreenSize().height
          / BackgroundImageOriginal.getHeight(null);
  Dimension GameDim =
      new Dimension(
          (int) (BackgroundImageOriginal.getWidth(null) * ScaleFactor),
          (int) (BackgroundImageOriginal.getHeight(null) * ScaleFactor));

  Image BackgroundImage = getScaledImage(BACKGROUND_DAY);

  Image SunFlowerImage = getScaledImage(SUNFLOWER);
  Image SunImage = getScaledImage(SUN);
  Image KillSunImage = getScaledImage(KILL_SUN);

  Image PeaShooterImage = getScaledImage(PEASHOOTER);
  Image PeaImage = getScaledImage(PEA);

  Image FreezePeaShooterImage = getScaledImage(SNOW_PEA);
  Image FreezePeaImage = getScaledImage(SNOW);

  Image RepeaterImage = getScaledImage(REPEATER);
  Image RepreaterCardIcon = getScaledImage(REPEATER_CARD);

  Image NormalZombieWalkImage = getScaledImage(NORMAL_ZOMBIE_WALK);
  Image NormalZombieEatImage = getScaledImage(NORMAL_ZOMBIE_EAT);
  Image NormalZombieDieImage = getScaledImage(NORMAL_ZOMBIE_DIE);
  Image NormalZombieLostHeadWalkImage = getScaledImage(NORMAL_ZOMBIE_LOST_HEAD_WALK);
  Image NormalZombieLostHeadEatImage = getScaledImage(NORMAL_ZOMBIE_LOST_HEAD_EAT);

  Image ConeHeadZombieWalkImage = getScaledImage(CONE_HEAD_ZOMBIE_WALK);
  Image ConeHeadZombieEatImage = getScaledImage(CONE_HEAD_ZOMBIE_EAT);

  Image BucketHeadZombieWalkImage = getScaledImage(BUCKET_HEAD_ZOMBIE_WALK);
  Image BucketHeadZombieEatImage = getScaledImage(BUCKET_HEAD_ZOMBIE_EAT);

  Image ThreePeaShooterImage = getScaledImage(THREE_PEASHOOTER);
  ImageIcon ThreePeaShooterCardIcon = new ImageIcon(getScaledImage(THREE_PEASHOOTER_CARD));

  Image ShovelImage = getScaledImage(SHOVEL, 0.65);

  ImageIcon ShovelButtonIcon = new ImageIcon(getScaledImage(SHOVEL_BUTTON, 0.65));
  ImageIcon SunFlowerCardIcon = new ImageIcon(getScaledImage(SUNFLOWER_CARD));
  ImageIcon PeaShooterCardIcon = new ImageIcon(getScaledImage(PEASHOOTER_CARD));
  ImageIcon FreezePeaShooterCardIcon = new ImageIcon(getScaledImage(SNOW_PEA_CARD));

  ImageIcon WalnutCardIcon = new ImageIcon(getScaledImage(WALNUT_CARD));
  Image Walnut1 = getScaledImage(WALNUT1);
  Image Walnut2 = getScaledImage(WALNUT2);
  Image Walnut3 = getScaledImage(WALNUT3);

  static Image getScaledImage(String path) {
    Image originalImage = new ImageIcon(path).getImage();
    return new ImageIcon(
        originalImage.getScaledInstance(
            (int) (originalImage.getWidth(null) * ScaleFactor),
            (int) (originalImage.getHeight(null) * ScaleFactor),
            Image.SCALE_DEFAULT)).getImage();
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
