package root.GameMode.Visuals;

import root.entities.plants.Repeater;

import javax.swing.ImageIcon;

public class NoScalingMode extends VisualMode {

  public NoScalingMode() {
    SunFlowerImage = new ImageIcon(SUNFLOWER).getImage();
    PeaShooterImage = new ImageIcon(PEASHOOTER).getImage();
    FreezePeaShooterImage = new ImageIcon(FREEZE_PEASHOOTER).getImage();
    SunImage = new ImageIcon(SUN).getImage();
    KillSunImage = new ImageIcon(KILLSUN).getImage();

    RepeaterImage = new ImageIcon(REPEATER).getImage();
    RepeaterCardIcon = new ImageIcon(REPEATER_CARD);

    PeaImage = new ImageIcon(PEA).getImage();
    FreezePeaImage = new ImageIcon(FREEZE_PEA).getImage();

    NormalZombieWalkImage = new ImageIcon(NORMAL_ZOMBIE_WALK).getImage();
    NormalZombieEatImage = new ImageIcon(NORMAL_ZOMBIE_EAT).getImage();
    NormalZombieLostHeadWalkImage = new ImageIcon(NORMAL_ZOMBIE_LOST_HEAD_WALK).getImage();
    NormalZombieLostHeadEatImage = new ImageIcon(NORMAL_ZOMBIE_LOST_HEAD_EAT).getImage();

    ConeHeadZombieWalkImage = new ImageIcon(CONE_HEAD_ZOMBIE_WALK).getImage();
    ConeHeadZombieEatImage = new ImageIcon(CONE_HEAD_ZOMBIE_EAT).getImage();

    BucketHeadZombieWalkImage = new ImageIcon(BUCKET_HEAD_ZOMBIE_WALK).getImage();
    BucketHeadZombieEatImage = new ImageIcon(BUCKET_HEAD_ZOMBIE_EAT).getImage();

    ShovelImage = new ImageIcon(SHOVEL).getImage();
    ShovelButtonImage = new ImageIcon(SHOVEL_BUTTON).getImage();
    LawnmowerImage = new ImageIcon(LAWNMOWER).getImage();
    LawnmowerMovingImage = new ImageIcon(LAWNMOWER_MOVING).getImage();

    ShovelButtonIcon = new ImageIcon(ShovelButtonImage);
    SunFlowerCardIcon = new ImageIcon(SUNFLOWER_CARD);
    PeaShooterCardIcon = new ImageIcon(PEASHOOTER_CARD);
    FreezePeaShooterCardIcon = new ImageIcon(FREEZE_PEASHOOTER_CARD);

    Walnut1 = new ImageIcon(WALNUT1).getImage();
    Walnut2 = new ImageIcon(WALNUT2).getImage();
    Walnut3 = new ImageIcon(WALNUT3).getImage();
    WalnutCardIcon = new ImageIcon(WALNUT_CARD);
//    Image ShovelImageOriginal = new ImageIcon(SHOVEL).getImage();
//    ShovelImage = ShovelImageOriginal
//        .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.5), (int) (ShovelImageOriginal.getHeight(null) * 0.5), Image.SCALE_DEFAULT);
//    Image ShovelButtonImageOriginal = new ImageIcon(SHOVEL_BUTTON).getImage();
//    ShovelButtonImage = ShovelButtonImageOriginal
//        .getScaledInstance((int) (ShovelImageOriginal.getWidth(null) * 0.75), (int) (ShovelImageOriginal.getHeight(null) * 0.75),
//            Image.SCALE_DEFAULT);
  }
}
