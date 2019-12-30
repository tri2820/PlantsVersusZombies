package root.GameMode.Visuals;

import javax.swing.ImageIcon;

public class NoScalingMode extends VisualMode {

  public NoScalingMode() {
    SunFlowerImage = new ImageIcon(SUNFLOWER).getImage();
    PeaShooterImage = new ImageIcon(PEASHOOTER).getImage();
    SnowPeaCardImage = new ImageIcon(SNOW_PEA).getImage();
    SunImage = new ImageIcon(SUN).getImage();
    KillSunImage = new ImageIcon(KILL_SUN).getImage();
    LuckyBalloonImage = new ImageIcon(LUCKY_BALLOON).getImage();

    RepeaterImage = new ImageIcon(REPEATER).getImage();
    RepeaterCardIcon = new ImageIcon(REPEATER_CARD);

    PeaImage = new ImageIcon(PEA).getImage();
    FreezePeaImage = new ImageIcon(SNOW).getImage();

    ThreePeaShooterImage = new ImageIcon(THREE_PEASHOOTER).getImage();
    ThreePeaShooterCardIcon = new ImageIcon(THREE_PEASHOOTER_CARD).getImage();

    NormalZombieWalkImage = new ImageIcon(NORMAL_ZOMBIE_WALK).getImage();
    NormalZombieEatImage = new ImageIcon(NORMAL_ZOMBIE_EAT).getImage();
    NormalZombieDieImage = new ImageIcon(NORMAL_ZOMBIE_DIE).getImage();
    NormalZombieLostHeadWalkImage = new ImageIcon(NORMAL_ZOMBIE_LOST_HEAD_WALK).getImage();
    NormalZombieLostHeadEatImage = new ImageIcon(NORMAL_ZOMBIE_LOST_HEAD_EAT).getImage();

    ConeHeadZombieWalkImage = new ImageIcon(CONE_HEAD_ZOMBIE_WALK).getImage();
    ConeHeadZombieEatImage = new ImageIcon(CONE_HEAD_ZOMBIE_EAT).getImage();

    BucketHeadZombieWalkImage = new ImageIcon(BUCKET_HEAD_ZOMBIE_WALK).getImage();
    BucketHeadZombieEatImage = new ImageIcon(BUCKET_HEAD_ZOMBIE_EAT).getImage();

    for (int i = 0; i < ZOMBIE_DIE.length; i++) {
      ZombieDie[i] = new ImageIcon(ZOMBIE_DIE[i]).getImage();
    }

    ShovelImage = new ImageIcon(SHOVEL).getImage();
    ShovelButtonImage = new ImageIcon(SHOVEL_BUTTON).getImage();
    LawnmowerImage = new ImageIcon(LAWNMOWER).getImage();
    LawnmowerMovingImage = new ImageIcon(LAWNMOWER_MOVING).getImage();

    ShovelButtonIcon = new ImageIcon(ShovelButtonImage);
    SunFlowerCardIcon = new ImageIcon(SUNFLOWER_CARD);
    PeaShooterCardIcon = new ImageIcon(PEASHOOTER_CARD);
    SnowPeaCardIcon = new ImageIcon(SNOW_PEA_CARD);

    Walnut1 = new ImageIcon(WALNUT1).getImage();
    Walnut2 = new ImageIcon(WALNUT2).getImage();
    Walnut3 = new ImageIcon(WALNUT3).getImage();
    WalnutCardIcon = new ImageIcon(WALNUT_CARD);
  }
}
