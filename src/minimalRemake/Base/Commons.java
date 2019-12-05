package minimalRemake.Base;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public interface Commons {
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

  Image Background = new ImageIcon(BACKGROUND).getImage();
  Image SunFlower = new ImageIcon(SUNFLOWER).getImage();
  Image PeaShooter = new ImageIcon(PEASHOOTER).getImage();
  Image FreezePeaShooter = new ImageIcon(FREEZE_PEASHOOTER).getImage();
  Image Sun = new ImageIcon(SUN).getImage();
  Image Pea = new ImageIcon(PEA).getImage();
  Image FreezePea = new ImageIcon(FREEZE_PEA).getImage();
  Image NormalZombie = new ImageIcon(NORMAL_ZOMBIE).getImage();
  Image ConeHeadZombie = new ImageIcon(CONE_HEAD_ZOMBIE).getImage();
  ImageIcon SunFlowerCard = new ImageIcon(SUNFLOWER_CARD);
  ImageIcon PeaShooterCard = new ImageIcon(PEASHOOTER_CARD);
  ImageIcon FreezePeaShooterCard = new ImageIcon(FREEZE_PEASHOOTER_CARD);

  Random luck = new Random();

  // Set Game dimension based on the background image
  Dimension GameDim = new Dimension(Background.getWidth(null), Background.getHeight(null));
  ArrayList<Image> images = new ArrayList<>();
  ArrayList<Dimension> sizes = new ArrayList<>();

  int[] cols = new int[9];
  int[] lanes = new int[5];

  static void init() {
    // Set coefficient to find each lane relative to the background
    lanes[0] = GameDim.height * 12 / 67;
    lanes[1] = GameDim.height * 23 / 67;
    lanes[2] = GameDim.height * 34 / 67;
    lanes[3] = GameDim.height * 45 / 67;
    lanes[4] = GameDim.height * 56 / 67;

    cols[0] = GameDim.width * 5 / 89;
    cols[1] = GameDim.width * 14 / 89;
    cols[2] = GameDim.width * 23 / 89;
    cols[3] = GameDim.width * 32 / 89;
    cols[4] = GameDim.width * 41 / 89;
    cols[5] = GameDim.width * 50 / 89;
    cols[6] = GameDim.width * 59 / 89;
    cols[7] = GameDim.width * 68 / 89;
    cols[8] = GameDim.width * 77 / 89;

    images.add(Background);
    images.add(SunFlower);
    images.add(PeaShooter);
    images.add(FreezePeaShooter);
    images.add(Sun);
    images.add(Pea);
    images.add(FreezePea);
    images.add(NormalZombie);
    images.add(ConeHeadZombie);

    for (Image i : images) sizes.add(new Dimension(i.getWidth(null), i.getHeight(null)));
  }
}
