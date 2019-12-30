package root.etc;

import java.io.File;

public interface ResourcesPath {

  //game basic element
  String PROJECT_DIR = new File("").getAbsolutePath();
  String RESOURCE_DIR = PROJECT_DIR + "/resource";
  String BACKGROUND_DAY = RESOURCE_DIR + "/background/BackgroundDay.png";
  String BACKGROUND_NIGHT = RESOURCE_DIR + "/background/BackgroundNight.png";
  String LAWNMOWER = RESOURCE_DIR + "/item/Lawnmower.png";
  String LAWNMOWER_MOVING = RESOURCE_DIR + "/item/LawnmowerMoving.gif";
  String SHOVEL = RESOURCE_DIR + "/item/Shovel.png";
  String SHOVEL_BUTTON = RESOURCE_DIR + "/item/ShovelButton.jpg";
  String START_GAME = RESOURCE_DIR + "/item/menu.png";

  //font
  String PvZUI_FONT = RESOURCE_DIR + "/Font/PvZUI.ttf";
  String SOL_FONT = RESOURCE_DIR + "/Font/solHeavy.ttf";

  //types of pea
  String PEA = RESOURCE_DIR + "/pea/Pea.png";
  String SNOW = RESOURCE_DIR + "/pea/Snow.png";
  String MUSHROOM = RESOURCE_DIR + "/pea/Mushroom.png";

  //type of sun
  String SUN = RESOURCE_DIR + "/pea/Sun.gif";
  String KILL_SUN = RESOURCE_DIR + "/pea/KillSun.png";
  String LUCKY_BALLOON = RESOURCE_DIR + "/item/lucky.png";

  //PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS PLANTS
  //repeater
  String REPEATER = RESOURCE_DIR + "/plants/Repeater.gif";
  String REPEATER_CARD = RESOURCE_DIR + "/cards/RepeaterCard.png";

  //sunflower
  String SUNFLOWER_CARD = RESOURCE_DIR + "/cards/SunFlowerCard.png";
  String SUNFLOWER = RESOURCE_DIR + "/plants/SunFlower.gif";

  //peashooter
  String PEASHOOTER_CARD = RESOURCE_DIR + "/cards/PeaShooterCard.png";
  String PEASHOOTER = RESOURCE_DIR + "/plants/PeaShooter.gif";

  //freeze pea shooter
  String SNOW_PEA_CARD = RESOURCE_DIR + "/cards/SnowPeaCard.png";
  String SNOW_PEA = RESOURCE_DIR + "/plants/SnowPea.gif";

  //three pea shooter
  String THREE_PEASHOOTER_CARD = RESOURCE_DIR + "/cards/ThreePeaShooterCard.png";
  String THREE_PEASHOOTER = RESOURCE_DIR + "/plants/ThreePeaShooter.gif";

  //walnut
  String WALNUT_CARD = RESOURCE_DIR + "/cards/WalnutCard.png";
  String WALNUT1 = RESOURCE_DIR + "/plants/walnut/Walnut1.gif";
  String WALNUT2 = RESOURCE_DIR + "/plants/walnut/Walnut2.gif";
  String WALNUT3 = RESOURCE_DIR + "/plants/walnut/Walnut3.gif";

  //Puff shroom
  String PUFF_SHROOM = RESOURCE_DIR + "/plants/PuffShroom.gif";
  String PUFF_SHROOM_CARD = RESOURCE_DIR + "/cards/PuffShroomCard.png";

  //sun shroom
  String SUN_SHROOM = RESOURCE_DIR + "/plants/SunShroom.gif";
  String SUN_SHROOM_CARD = RESOURCE_DIR + "/cards/SunShroomCard.png";

  //ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE ZOMBIE
  //zombie
  String NORMAL_ZOMBIE = RESOURCE_DIR + "/zombies/NormalZombie/NormalZombie.gif";
  String NORMAL_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/NormalZombie/NormalZombieAttack.gif";
  String NORMAL_ZOMBIE_LOST_HEAD = RESOURCE_DIR + "/zombies/NormalZombie/NormalZombieLostHead.gif";
  String NORMAL_ZOMBIE_LOST_HEAD_EAT = RESOURCE_DIR + "/zombies/NormalZombie/NormalZombieLostHeadAttack.gif";
  String NORMAL_ZOMBIE_DIE = RESOURCE_DIR + "/zombies/NormalZombieDie.gif";

  //ConeHead zombie
  String CONE_HEAD_ZOMBIE = RESOURCE_DIR + "/zombies/ConeHeadZombie/ConeHeadZombie.gif";
  String CONE_HEAD_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/ConeHeadZombie/ConeHeadZombieAttack.gif";

  //BucketHead zombie
  String BUCKET_HEAD_ZOMBIE = RESOURCE_DIR + "/zombies/BucketHeadZombie/BucketHeadZombie.gif";
  String BUCKET_HEAD_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/BucketHeadZombie/BucketHeadZombieAttack.gif";

  //Newspaper zombie
  String NEWSPAPER_ZOMBIE = RESOURCE_DIR + "/zombies/NewspaperZombie/NewspaperZombie.gif";
  String NEWSPAPER_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/NewspaperZombie/NewspaperZombieAttack.gif";
  String NEWS_ZOMBIE = RESOURCE_DIR + "/zombies/NewspaperZombie/NewsZombie.gif";
  String NEWS_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/NewspaperZombie/NewsZombieAttack.gif";
  String NEWS_ZOMBIE_LOST_HEAD = RESOURCE_DIR + "/zombies/NewspaperZombie/NewsZombieLostHead.gif";
  String NEWS_ZOMBIE_LOST_HEAD_EAT = RESOURCE_DIR + "/zombies/NewspaperZombie/NewsZombieLostHeadAttack.gif";

  //flag zombie
  String FLAG_ZOMBIE = RESOURCE_DIR + "/zombies/FlagZombie/FlagZombie.gif";
  String FLAG_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/FlagZombie/FlagZombieAttack.gif";
  String FLAG_ZOMBIE_LOST_HEAD = RESOURCE_DIR + "/zombies/FlagZombie/FlagZombieLostHead.gif";
  String FLAG_ZOMBIE_LOST_HEAD_EAT = RESOURCE_DIR + "/zombies/FlagZombie/FlagZombieLostHeadAttack.gif";

  //zombie die
  String[] ZOMBIE_DIE = {
      RESOURCE_DIR + "/zombies/zombie_die/frame_00_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_01_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_02_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_03_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_04_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_05_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_06_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_07_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_08_delay-0.2s.png",
      RESOURCE_DIR + "/zombies/zombie_die/frame_09_delay-0.2s.png"
  };
}
