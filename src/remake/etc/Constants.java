package remake.etc;

import java.io.File;

public interface Constants {

  String PROJECT_DIR = new File("").getAbsolutePath();
  String RESOURCE_DIR = PROJECT_DIR + "/resource";
  String BACKGROUND = RESOURCE_DIR + "/Background.png";
  String SUNFLOWER = RESOURCE_DIR + "/plants/SunFlower.gif";
  String PEASHOOTER = RESOURCE_DIR + "/plants/PeaShooter.gif";
  String FREEZE_PEASHOOTER = RESOURCE_DIR + "/plants/FreezePeaShooter.gif";
  String SUN = RESOURCE_DIR + "/Sun.png";
  String PEA = RESOURCE_DIR + "/Pea.png";
  String FREEZE_PEA = RESOURCE_DIR + "/FreezePea.png";
  String NORMAL_ZOMBIE = RESOURCE_DIR + "/zombies/NormalZombie.png";
  String CONE_HEAD_ZOMBIE = RESOURCE_DIR + "/zombies/ConeHeadZombie.png";
  String SUNFLOWER_CARD = RESOURCE_DIR + "/cards/SunFlowerCard.png";
  String PEASHOOTER_CARD = RESOURCE_DIR + "/cards/PeaShooterCard.png";
  String FREEZE_PEASHOOTER_CARD = RESOURCE_DIR + "/cards/FreezePeaShooterCard.png";
  String SHOVEL = RESOURCE_DIR + "/Shovel.png";
  String SHOVEL_BUTTON = RESOURCE_DIR + "/ShovelButton.jpg";
  String LAWNMOWER = RESOURCE_DIR + "/Lawnmower.png";
  String SOL_FONT = "Sol";
  int DELAY = 25;
}
