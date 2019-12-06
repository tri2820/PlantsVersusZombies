package PvZ.Base;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public interface NoScalingMode extends Directories {

  Image BackgroundImage = new ImageIcon(BACKGROUND).getImage();
  Image SunFlowerImage = new ImageIcon(SUNFLOWER).getImage();
  Image PeaShooterImage = new ImageIcon(PEASHOOTER).getImage();
  Image FreezePeaShooterImage = new ImageIcon(FREEZE_PEASHOOTER).getImage();
  Image SunImage = new ImageIcon(SUN).getImage();
  Image PeaImage = new ImageIcon(PEA).getImage();
  Image FreezePeaImage = new ImageIcon(FREEZE_PEA).getImage();
  Image NormalZombieImage = new ImageIcon(NORMAL_ZOMBIE).getImage();
  Image ConeHeadZombieImage = new ImageIcon(CONE_HEAD_ZOMBIE).getImage();
  Image ShovelImageOriginal = new ImageIcon(SHOVEL).getImage();
  Image ShovelImage = ShovelImageOriginal
      .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.5), (int) (ShovelImageOriginal.getHeight(null) * 0.5), Image.SCALE_DEFAULT);
  Image ShovelButtonImageOriginal = new ImageIcon(SHOVEL_BUTTON).getImage();
  Image ShovelButtonImage = ShovelButtonImageOriginal
      .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.75), (int) (ShovelImageOriginal.getHeight(null) * 0.75), Image.SCALE_DEFAULT);

  ImageIcon ShovelButtonIcon = new ImageIcon(ShovelButtonImage);
  ImageIcon SunFlowerCardIcon = new ImageIcon(SUNFLOWER_CARD);
  ImageIcon PeaShooterCardIcon = new ImageIcon(PEASHOOTER_CARD);
  ImageIcon FreezePeaShooterCardIcon = new ImageIcon(FREEZE_PEASHOOTER_CARD);

  Dimension GameDim = new Dimension(BackgroundImage.getWidth(null), BackgroundImage.getHeight(null));
}
