package root.GameMode.Visuals;

import javax.swing.ImageIcon;

public class NoScalingMode extends VisualMode {

  public NoScalingMode() {
    SunFlowerImage = new ImageIcon(SUNFLOWER).getImage();
    PeaShooterImage = new ImageIcon(PEASHOOTER).getImage();
    FreezePeaShooterImage = new ImageIcon(FREEZE_PEASHOOTER).getImage();
    SunImage = new ImageIcon(SUN).getImage();
    PeaImage = new ImageIcon(PEA).getImage();
    FreezePeaImage = new ImageIcon(FREEZE_PEA).getImage();
    NormalZombieImage = new ImageIcon(NORMAL_ZOMBIE).getImage();
    ConeHeadZombieImage = new ImageIcon(CONE_HEAD_ZOMBIE).getImage();
    HeadlessZombieImage = new ImageIcon(HEAD_LESS_ZOMBIE).getImage();
    ShovelImage = new ImageIcon(SHOVEL).getImage();
    ShovelButtonImage = new ImageIcon(SHOVEL_BUTTON).getImage();
    LawnmowerImage = new ImageIcon(LAWNMOWER).getImage();

    ShovelButtonIcon = new ImageIcon(ShovelButtonImage);
    SunFlowerCardIcon = new ImageIcon(SUNFLOWER_CARD);
    PeaShooterCardIcon = new ImageIcon(PEASHOOTER_CARD);
    FreezePeaShooterCardIcon = new ImageIcon(FREEZE_PEASHOOTER_CARD);
//    Image ShovelImageOriginal = new ImageIcon(SHOVEL).getImage();
//    ShovelImage = ShovelImageOriginal
//        .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.5), (int) (ShovelImageOriginal.getHeight(null) * 0.5), Image.SCALE_DEFAULT);
//    Image ShovelButtonImageOriginal = new ImageIcon(SHOVEL_BUTTON).getImage();
//    ShovelButtonImage = ShovelButtonImageOriginal
//        .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.75), (int) (ShovelImageOriginal.getHeight(null) * 0.75),
//            Image.SCALE_DEFAULT);
  }
}
