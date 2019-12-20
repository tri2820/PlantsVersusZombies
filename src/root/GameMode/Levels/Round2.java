package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.entities.plants.FreezePeaShooter;
import root.entities.plants.Walnut;
import root.entities.zombies.ConeHeadZombie;

public class Round2 extends Round1 {

  public Round2(GamePanel gamePanel) {
    super(gamePanel);

    plantClasses.add(FreezePeaShooter.class);
    plantClasses.add(Walnut.class);
    zombieClasses.add(ConeHeadZombie.class);

    cards.add(new IconButton(gamePanel.visualMode.FreezePeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 22 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.FreezePeaShooterImage, gamePanel));
    cards.add(new IconButton(gamePanel.visualMode.WalnutCardIcon, gamePanel.visualMode.GameDim.width * 28 / 90,
            gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.Walnut1, gamePanel));

    MAX_ZOMBIES = 30;
  }
}
