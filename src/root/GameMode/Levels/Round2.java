package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GUI.Decorator;
import root.entities.plants.FreezePeaShooter;
import root.entities.plants.Repeater;
import root.entities.zombies.BucketHeadZombie;
import root.entities.zombies.ConeHeadZombie;

public class Round2 extends Round1 {

  public Round2(GamePanel gamePanel) {
    super(gamePanel);

    //zombie
    zombieClasses.add(ConeHeadZombie.class);
    zombieClasses.add(BucketHeadZombie.class);

    //plant
    plantClasses.add(FreezePeaShooter.class);
    cards.add(new Decorator(gamePanel.visualMode.FreezePeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 28 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.FreezePeaShooterImage, gamePanel));

    plantClasses.add(Repeater.class);
    cards.add(new Decorator(gamePanel.visualMode.RepeaterCardIcon, gamePanel.visualMode.GameDim.width * 34 / 90,
            gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.RepeaterImage, gamePanel));

    MAX_ZOMBIES = 60;
  }
}
