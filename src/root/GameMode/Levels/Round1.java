package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.entities.plants.FreezePeaShooter;
import root.entities.plants.Lawnmower;
import root.entities.plants.PeaShooter;
import root.entities.plants.Repeater;
import root.entities.plants.SunFlower;
import root.entities.plants.Walnut;
import root.entities.zombies.NormalZombie;
import root.etc.CellsManager;

public class Round1 extends Level {

  public Round1(GamePanel gamePanel) {
    super(gamePanel);

    cards.add(new IconButton(gamePanel.visualMode.ShovelButtonIcon, gamePanel.visualMode.GameDim.width * 57 / 100, 0,
        gamePanel.visualMode.ShovelImage, gamePanel));

    //zombie
    zombieClasses.add(NormalZombie.class);


    //plant
    plantClasses.add(SunFlower.class);
    cards.add(new IconButton(gamePanel.visualMode.SunFlowerCardIcon, gamePanel.visualMode.GameDim.width * 10 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SunFlowerImage, gamePanel));

    plantClasses.add(PeaShooter.class);
    cards.add(new IconButton(gamePanel.visualMode.PeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 16 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.PeaShooterImage, gamePanel));

    plantClasses.add(Walnut.class);
    cards.add(new IconButton(gamePanel.visualMode.WalnutCardIcon, gamePanel.visualMode.GameDim.width * 22 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.Walnut1, gamePanel));

    plantClasses.add(FreezePeaShooter.class);
    cards.add(new IconButton(gamePanel.visualMode.FreezePeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 28 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.FreezePeaShooterImage, gamePanel));

    plantClasses.add(Repeater.class);
    cards.add(new IconButton(gamePanel.visualMode.RepeaterCardIcon, gamePanel.visualMode.GameDim.width * 34 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.RepeaterImage, gamePanel));



    for (int lane : CellsManager.lanes) {
      lawnmowers.add(new Lawnmower(0, lane));
    }

    MAX_ZOMBIES = 30;
  }
}
