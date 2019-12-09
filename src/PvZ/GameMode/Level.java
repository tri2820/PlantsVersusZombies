package PvZ.GameMode;

import PvZ.Commons;

public abstract class Level implements Commons {

  // Control variables
  public int numOfSuns;
  public int numOfZombies;
  public int delayTimeBtwZombies;

  public int Price_SunFlower;
  public int Price_PeaShooter;
  public int Price_FreezePeaShooter;
  public int BulletSpeedX;
  public int BulletSpeedY;
  public int SunSpeedBoundX;
  public int SunSpeedBoundY;
  public int ZombieSpeed;
}
