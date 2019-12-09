package remake.GameMode.Levels;

import remake.GUI.GamePanel;
import remake.GUI.IconButton;
import remake.entities.plants.PeaShooter;
import remake.entities.plants.SunFlower;
import remake.entities.zombies.NormalZombie;

public class Round1 extends Level {

  public Round1(GamePanel gamePanel) {
    super(gamePanel);
    MAX_ZOMBIES = 20;

    plantClasses.add(SunFlower.class);
    plantClasses.add(PeaShooter.class);

    zombieClasses.add(NormalZombie.class);
    cards.add(
        new IconButton(gamePanel.visualMode.SunFlowerCardIcon, gamePanel.visualMode.GameDim.width * 10 / 90, gamePanel.visualMode.GameDim.height / 67,
            gamePanel.visualMode.SunFlowerImage, gamePanel));
    cards.add(new IconButton(gamePanel.visualMode.PeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 16 / 90,
        gamePanel.visualMode.GameDim.height / 67,
        gamePanel.visualMode.PeaShooterImage, gamePanel));
    cards.add(new IconButton(gamePanel.visualMode.ShovelButtonIcon, gamePanel.visualMode.GameDim.width * 57 / 100, 0,
        gamePanel.visualMode.ShovelImage, gamePanel));
  }
}
