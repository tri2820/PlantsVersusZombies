package remake.GameMode.Levels;

import remake.GUI.GamePanel;
import remake.GUI.IconButton;
import remake.entities.plants.FreezePeaShooter;
import remake.entities.zombies.ConeHeadZombie;

public class Round2 extends Round1 {

  public Round2(GamePanel gamePanel) {
    super(gamePanel);
    MAX_ZOMBIES = 30;

    plantClasses.add(FreezePeaShooter.class);
    zombieClasses.add(ConeHeadZombie.class);

    cards.add(new IconButton(gamePanel.visualMode.FreezePeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 22 / 90,
        gamePanel.visualMode.GameDim.height / 67,
        gamePanel.visualMode.FreezePeaShooterImage, gamePanel));
  }
}
