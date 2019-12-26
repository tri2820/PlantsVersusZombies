package root.etc;

import java.io.File;

public interface ResourcesPath {
  //game basic element
  String PROJECT_DIR = new File("").getAbsolutePath();
  String RESOURCE_DIR = PROJECT_DIR + "/resource";
  String BACKGROUND = RESOURCE_DIR + "/Background.png";
  String LAWNMOWER = RESOURCE_DIR + "/Lawnmower.png";
  String LAWNMOWER_MOVING = RESOURCE_DIR + "/LawnmowerMoving.gif";
  String SHOVEL = RESOURCE_DIR + "/Shovel.png";
  String SHOVEL_BUTTON = RESOURCE_DIR + "/ShovelButton.jpg";

  //type of sun
  String SUN = RESOURCE_DIR + "/Sun.gif";
  String KILLSUN = RESOURCE_DIR + "/KillSun.png";

  //repeater
  String REPEATER = RESOURCE_DIR + "/plants/Repeater.gif";
  String REPEATER_CARD = RESOURCE_DIR + "/cards/RepeaterCard.png";

  //zombie
  String NORMAL_ZOMBIE_WALK = RESOURCE_DIR + "/zombies/NormalZombieWalk.gif";
  String NORMAL_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/NormalZombieAttack.gif";
  String NORMAL_ZOMBIE_LOST_HEAD_WALK = RESOURCE_DIR + "/zombies/NormalZombieLostHeadWalk.gif";
  String NORMAL_ZOMBIE_LOST_HEAD_EAT = RESOURCE_DIR + "/zombies/NormalZombieLostHeadAttack.gif";

  //conehead zombie
  String CONE_HEAD_ZOMBIE_WALK = RESOURCE_DIR + "/zombies/ConeHeadZombieWalk.gif";
  String CONE_HEAD_ZOMBIE_EAT = RESOURCE_DIR + "/zombies/ConeHeadZombieAttack.gif";

  //sunflower
  String SUNFLOWER_CARD = RESOURCE_DIR + "/cards/SunFlowerCard.png";
  String SUNFLOWER = RESOURCE_DIR + "/plants/SunFlower.gif";

  //peashooter
  String PEASHOOTER_CARD = RESOURCE_DIR + "/cards/PeaShooterCard.png";
  String PEASHOOTER = RESOURCE_DIR + "/plants/PeaShooter.gif";

  //freeze pea shooter
  String FREEZE_PEASHOOTER_CARD = RESOURCE_DIR + "/cards/FreezePeaShooterCard.png";
  String FREEZE_PEASHOOTER = RESOURCE_DIR + "/plants/FreezePeaShooter.gif";

  //types of pea
  String PEA = RESOURCE_DIR + "/Pea.png";
  String FREEZE_PEA = RESOURCE_DIR + "/FreezePea.png";

  //font
  String SOL_FONT = RESOURCE_DIR + "/Font/PvZUI.ttf";

  //walnut
  String WALNUT_CARD = RESOURCE_DIR + "/plants/walnut/wallnutcard.png";
  String WALNUT1 = RESOURCE_DIR + "/plants/walnut/Wallnut1.gif";
  String WALNUT2 = RESOURCE_DIR + "/plants/walnut/Wallnut2.gif";
  String WALNUT3 = RESOURCE_DIR + "/plants/walnut/Wallnut3.gif";
}
