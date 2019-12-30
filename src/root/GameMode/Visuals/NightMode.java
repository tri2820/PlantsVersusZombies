package root.GameMode.Visuals;

import javax.swing.ImageIcon;

public class NightMode extends VisualMode {

  public NightMode() {
    BackgroundImage = new ImageIcon(BACKGROUND_NIGHT).getImage();

    ////////////////////// CHANGE TO DARK MODE PLANTS BELOW
    SunFlowerImage = new ImageIcon(SUNFLOWER).getImage();
    PeaShooterImage = new ImageIcon(PEASHOOTER).getImage();
    SnowPeaImage = new ImageIcon(SNOW_PEA).getImage();
    SunImage = new ImageIcon(SUN).getImage();
    KillSunImage = new ImageIcon(KILL_SUN).getImage();
    LuckyBalloonImage = new ImageIcon(LUCKY_BALLOON).getImage();
    ShovelImage = new ImageIcon(SHOVEL).getImage();
    ShovelButtonImage = new ImageIcon(SHOVEL_BUTTON).getImage();
    LawnmowerImage = new ImageIcon(LAWNMOWER).getImage();
    LawnmowerMovingImage = new ImageIcon(LAWNMOWER_MOVING).getImage();

    ShovelButtonIcon = new ImageIcon(ShovelButtonImage);
    SunFlowerCardIcon = new ImageIcon(SUNFLOWER_CARD);
    PeaShooterCardIcon = new ImageIcon(PEASHOOTER_CARD);
    SnowPeaCardIcon = new ImageIcon(SNOW_PEA_CARD);

    //PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS

    //repeater
    RepeaterImage = new ImageIcon(REPEATER).getImage();
    RepeaterCardIcon = new ImageIcon(REPEATER_CARD);

    //types of pea
    PeaImage = new ImageIcon(PEA).getImage();
    FreezePeaImage = new ImageIcon(SNOW).getImage();

    //three pea shooter
    ThreePeaShooterImage = new ImageIcon(THREE_PEASHOOTER).getImage();
    ThreePeaShooterCardIcon = new ImageIcon(THREE_PEASHOOTER_CARD);

    //walnut
    Walnut1 = new ImageIcon(WALNUT1).getImage();
    Walnut2 = new ImageIcon(WALNUT2).getImage();
    Walnut3 = new ImageIcon(WALNUT3).getImage();
    WalnutCardIcon = new ImageIcon(WALNUT_CARD);

    //ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE

    //normal zombie
    NormalZombieWalkImage = new ImageIcon(NORMAL_ZOMBIE_WALK).getImage();
    NormalZombieEatImage = new ImageIcon(NORMAL_ZOMBIE_EAT).getImage();
    NormalZombieDieImage = new ImageIcon(NORMAL_ZOMBIE_DIE).getImage();
    NormalZombieLostHeadWalkImage = new ImageIcon(NORMAL_ZOMBIE_LOST_HEAD_WALK).getImage();
    NormalZombieLostHeadEatImage = new ImageIcon(NORMAL_ZOMBIE_LOST_HEAD_EAT).getImage();

    //cone head zombie
    ConeHeadZombieWalkImage = new ImageIcon(CONE_HEAD_ZOMBIE_WALK).getImage();
    ConeHeadZombieEatImage = new ImageIcon(CONE_HEAD_ZOMBIE_EAT).getImage();

    //bucket head zombie
    BucketHeadZombieWalkImage = new ImageIcon(BUCKET_HEAD_ZOMBIE_WALK).getImage();
    BucketHeadZombieEatImage = new ImageIcon(BUCKET_HEAD_ZOMBIE_EAT).getImage();

    //flag zombie
    FlagZombieImage = new ImageIcon(FLAG_ZOMBIE).getImage();
    FlagZombieEatImage = new ImageIcon(FLAG_ZOMBIE_EAT).getImage();
    FlagZombieLostHeadImage = new ImageIcon(FLAG_ZOMBIE_LOST_HEAD).getImage();
    FlagZombieLostHeadEatImage = new ImageIcon(FLAG_ZOMBIE_LOST_HEAD_EAT).getImage();

    //newspaper zombie
    NewspaperZombieImage = new ImageIcon(NEWSPAPER_ZOMBIE).getImage();
    NewspaperZombieEatImage = new ImageIcon(NEWSPAPER_ZOMBIE_EAT).getImage();
    NewsZombieImage = new ImageIcon(NEWS_ZOMBIE).getImage();
    NewsZombieEatImage = new ImageIcon(NEWS_ZOMBIE_EAT).getImage();
    NewsZombieLostHeadImage = new ImageIcon(NEWS_ZOMBIE_LOST_HEAD).getImage();
    NewsZombieLostHeadEatImage = new ImageIcon(NEWS_ZOMBIE_LOST_HEAD_EAT).getImage();

    //zombie die
    for (int i = 0; i < ZOMBIE_DIE.length; i++) {
      ZombieDie[i] = new ImageIcon(ZOMBIE_DIE[i]).getImage();
    }
  }
}
