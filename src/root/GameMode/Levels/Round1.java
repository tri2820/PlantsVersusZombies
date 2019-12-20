package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.entities.plants.Lawnmower;
import root.entities.plants.PeaShooter;
import root.entities.plants.Walnut;
import root.entities.stuffs.SunFlower;
import root.entities.zombies.NormalZombie;
import root.etc.CellsManager;

public class Round1 extends Level {

  public Round1(GamePanel gamePanel) {
    super(gamePanel);

    plantClasses.add(PeaShooter.class);
    zombieClasses.add(NormalZombie.class);
    plantClasses.add(SunFlower.class);
    plantClasses.add(Walnut.class);

    cards.add(new IconButton(gamePanel.visualMode.ShovelButtonIcon, gamePanel.visualMode.GameDim.width * 57 / 100, 0,
        gamePanel.visualMode.ShovelImage, gamePanel));

    cards.add(new IconButton(gamePanel.visualMode.SunFlowerCardIcon, gamePanel.visualMode.GameDim.width * 10 / 90,
                gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SunFlowerImage, gamePanel));
    cards.add(new IconButton(gamePanel.visualMode.PeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 16 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.PeaShooterImage, gamePanel));

    cards.add(new IconButton(gamePanel.visualMode.WalnutCardIcon, gamePanel.visualMode.GameDim.width * 22 / 90,
            gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.Walnut1, gamePanel));

    for (int lane : CellsManager.lanes) {
      lawnmowers.add(new Lawnmower(0, lane));
    }

    MAX_ZOMBIES = 50;
  }
}
