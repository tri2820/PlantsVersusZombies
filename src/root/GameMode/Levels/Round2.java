package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.GameMode.Visuals.NoScalingMode;
import root.entities.plants.Repeater;
import root.entities.plants.SnowPea;
import root.entities.plants.ThreePeaShooter;
import root.entities.zombies.BucketHeadZombie;
import root.entities.zombies.ConeHeadZombie;
import root.entities.zombies.NewspaperZombie;

public class Round2 extends Round1 {

  public Round2() {
    visualMode = new NoScalingMode();
  }


  public Round2(GamePanel gamePanel) {
    super(gamePanel);

    //zombie
    zombieClasses.add(ConeHeadZombie.class);
    zombieClasses.add(BucketHeadZombie.class);
    zombieClasses.add(NewspaperZombie.class);

    //plant
    plantClasses.add(SnowPea.class);
    cards.add(new IconButton(gamePanel.visualMode.SnowPeaCardIcon, gamePanel.visualMode.GameDim.width * 28 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SnowPeaImage, gamePanel));

    plantClasses.add(Repeater.class);
    cards.add(new IconButton(gamePanel.visualMode.RepeaterCardIcon, gamePanel.visualMode.GameDim.width * 34 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.RepeaterImage, gamePanel));

    plantClasses.add(ThreePeaShooter.class);
    cards.add(new IconButton(gamePanel.visualMode.ThreePeaShooterCardIcon, gamePanel.visualMode.GameDim.width * 40 / 90,
        gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.ThreePeaShooterImage, gamePanel));

    MAX_ZOMBIES = 50;
  }
}
