package PvZ.GameMode;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class NoScalingMode extends VisualMode {

  public NoScalingMode() {
    BackgroundImage = new ImageIcon(BACKGROUND).getImage();
    SunFlowerImage = new ImageIcon(SUNFLOWER).getImage();
    PeaShooterImage = new ImageIcon(PEASHOOTER).getImage();
    FreezePeaShooterImage = new ImageIcon(FREEZE_PEASHOOTER).getImage();
    SunImage = new ImageIcon(SUN).getImage();
    PeaImage = new ImageIcon(PEA).getImage();
    FreezePeaImage = new ImageIcon(FREEZE_PEA).getImage();
    NormalZombieImage = new ImageIcon(NORMAL_ZOMBIE).getImage();
    ConeHeadZombieImage = new ImageIcon(CONE_HEAD_ZOMBIE).getImage();
    Image ShovelImageOriginal = new ImageIcon(SHOVEL).getImage();
    ShovelImage = ShovelImageOriginal
        .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.5), (int) (ShovelImageOriginal.getHeight(null) * 0.5), Image.SCALE_DEFAULT);
    Image ShovelButtonImageOriginal = new ImageIcon(SHOVEL_BUTTON).getImage();
    ShovelButtonImage = ShovelButtonImageOriginal
        .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.75), (int) (ShovelImageOriginal.getHeight(null) * 0.75),
            Image.SCALE_DEFAULT);

    ShovelButtonIcon = new ImageIcon(ShovelButtonImage);
    SunFlowerCardIcon = new ImageIcon(SUNFLOWER_CARD);
    PeaShooterCardIcon = new ImageIcon(PEASHOOTER_CARD);
    FreezePeaShooterCardIcon = new ImageIcon(FREEZE_PEASHOOTER_CARD);

    GameDim = new Dimension(BackgroundImage.getWidth(null), BackgroundImage.getHeight(null));
  }
}
