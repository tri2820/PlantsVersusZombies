package PvZ.Base;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public interface Commons extends NoScalingMode {

  Random luck = new Random();

  /***** Default actions *****/
  ArrayList<Image> images = new ArrayList<>();
  ArrayList<ImageIcon> icons = new ArrayList<>();
  ArrayList<Dimension> sizes = new ArrayList<>();

  int[] cols = new int[9];
  int[] lanes = new int[5];
  ArrayList<Point> cells = new ArrayList<>(cols.length * lanes.length);

  static void initResource() {
    images.add(BackgroundImage);
    images.add(SunFlowerImage);
    images.add(PeaShooterImage);
    images.add(FreezePeaShooterImage);
    images.add(SunImage);
    images.add(PeaImage);
    images.add(FreezePeaImage);
    images.add(NormalZombieImage);
    images.add(ConeHeadZombieImage);
    images.add(ShovelImage);

    icons.add(SunFlowerCardIcon);
    icons.add(PeaShooterCardIcon);
    icons.add(FreezePeaShooterCardIcon);
    icons.add(ShovelButtonIcon);

    for (Image i : images) {
      sizes.add(new Dimension(i.getWidth(null), i.getHeight(null)));
    }
  }

  static void initCells() {
    // Set coefficient to find each lane relative to the background
    cols[0] = GameDim.width * 5 / 89;
    cols[1] = GameDim.width * 14 / 89;
    cols[2] = GameDim.width * 23 / 89;
    cols[3] = GameDim.width * 32 / 89;
    cols[4] = GameDim.width * 41 / 89;
    cols[5] = GameDim.width * 50 / 89;
    cols[6] = GameDim.width * 59 / 89;
    cols[7] = GameDim.width * 68 / 89;
    cols[8] = GameDim.width * 77 / 89;

    lanes[0] = GameDim.height * 12 / 67;
    lanes[1] = GameDim.height * 23 / 67;
    lanes[2] = GameDim.height * 34 / 67;
    lanes[3] = GameDim.height * 45 / 67;
    lanes[4] = GameDim.height * 56 / 67;

    for (int col : cols) {
      for (int lane : lanes) {
        cells.add(new Point(col, lane));
      }
    }
  }

  static void initAll() {
    initCells();
    initResource();
  }
}
