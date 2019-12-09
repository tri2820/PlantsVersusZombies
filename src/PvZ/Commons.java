package PvZ;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import remake.GameMode.Visuals.NoScalingMode;
import remake.GameMode.Visuals.VisualMode;
import remake.etc.Constants;

public interface Commons extends Constants {

  /**** Choose configs ****/
  VisualMode visual = new NoScalingMode();

  /***** Default actions *****/
  Random luck = new Random();

  ArrayList<Image> images = new ArrayList<>();
  ArrayList<ImageIcon> icons = new ArrayList<>();
  ArrayList<Dimension> sizes = new ArrayList<>();

  int[] cols = new int[9];
  int[] lanes = new int[5];
  ArrayList<Point> cells = new ArrayList<>(cols.length * lanes.length);

  static void initResource() {
    images.add(visual.BackgroundImage);
    images.add(visual.SunFlowerImage);
    images.add(visual.PeaShooterImage);
    images.add(visual.FreezePeaShooterImage);
    images.add(visual.SunImage);
    images.add(visual.PeaImage);
    images.add(visual.FreezePeaImage);
    images.add(visual.NormalZombieImage);
    images.add(visual.ConeHeadZombieImage);
    images.add(visual.ShovelImage);

    icons.add(visual.SunFlowerCardIcon);
    icons.add(visual.PeaShooterCardIcon);
    icons.add(visual.FreezePeaShooterCardIcon);
    icons.add(visual.ShovelButtonIcon);

    for (Image i : images) {
      sizes.add(new Dimension(i.getWidth(null), i.getHeight(null)));
    }
  }

  static void initCells() {
    // Set coefficient to find each lane relative to the background
    cols[0] = visual.GameDim.width * 5 / 89;
    cols[1] = visual.GameDim.width * 14 / 89;
    cols[2] = visual.GameDim.width * 23 / 89;
    cols[3] = visual.GameDim.width * 32 / 89;
    cols[4] = visual.GameDim.width * 41 / 89;
    cols[5] = visual.GameDim.width * 50 / 89;
    cols[6] = visual.GameDim.width * 59 / 89;
    cols[7] = visual.GameDim.width * 68 / 89;
    cols[8] = visual.GameDim.width * 77 / 89;

    lanes[0] = visual.GameDim.height * 12 / 67;
    lanes[1] = visual.GameDim.height * 23 / 67;
    lanes[2] = visual.GameDim.height * 34 / 67;
    lanes[3] = visual.GameDim.height * 45 / 67;
    lanes[4] = visual.GameDim.height * 56 / 67;

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
