package root.etc;

import java.io.File;

public interface Constants {
    //game basic element
  String PROJECT_DIR = new File("").getAbsolutePath();
  String RESOURCE_DIR = PROJECT_DIR + "/resource";
  String BACKGROUND = RESOURCE_DIR + "/Background.png";
  String LAWNMOWER = RESOURCE_DIR + "/Lawnmower.png";
  String SHOVEL = RESOURCE_DIR + "/Shovel.png";
  String SHOVEL_BUTTON = RESOURCE_DIR + "/ShovelButton.jpg";

  String KILLSUN = RESOURCE_DIR + "/KillSun.png";

  String SUNFLOWER = RESOURCE_DIR + "/plants/SunFlower.gif";
  String PEASHOOTER = RESOURCE_DIR + "/plants/PeaShooter.gif";
  String FREEZE_PEASHOOTER = RESOURCE_DIR + "/plants/FreezePeaShooter.gif";
  String SUN = RESOURCE_DIR + "/Sun.png";
  String PEA = RESOURCE_DIR + "/Pea.png";
  String FREEZE_PEA = RESOURCE_DIR + "/FreezePea.png";
  String NORMAL_ZOMBIE = RESOURCE_DIR + "/zombies/NormalZombie.png";
  String CONE_HEAD_ZOMBIE = RESOURCE_DIR + "/zombies/ConeHeadZombie.png";
  String HEAD_LESS_ZOMBIE = RESOURCE_DIR + "/zombies/HeadlessZombie.png";
  String SUNFLOWER_CARD = RESOURCE_DIR + "/cards/SunFlowerCard.png";
  String PEASHOOTER_CARD = RESOURCE_DIR + "/cards/PeaShooterCard.png";
  String FREEZE_PEASHOOTER_CARD = RESOURCE_DIR + "/cards/FreezePeaShooterCard.png";


  //font
  String SOL_FONT = RESOURCE_DIR + "/Font/PvZUI.ttf";

  //walnut
  String WALNUT_CARD = RESOURCE_DIR + "/plants/walnut/wallnutcard.png";
  String WALNUT1 = RESOURCE_DIR + "/plants/walnut/wallnut1.png";
  String WALNUT2 = RESOURCE_DIR + "/plants/walnut/wallnut2.png";
  String WALNUT3 = RESOURCE_DIR + "/plants/walnut/wallnut3.png";
}
