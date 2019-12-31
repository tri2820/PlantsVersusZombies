package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GUI.IconButton;
import root.GameMode.Visuals.NightMode;
import root.entities.plants.PuffShroom;
import root.entities.plants.SunShroom;
import root.entities.plants.ThreePeaShooter;
import root.entities.zombies.BucketHeadZombie;
import root.entities.zombies.ConeHeadZombie;
import root.entities.zombies.NewspaperZombie;

public class Round3 extends Round2 {

  public Round3() {
    visualMode = new NightMode();
  }

  public Round3(GamePanel gamePanel) {
    super(gamePanel);

    //plant
    plantClasses.add(SunShroom.class);
    cards.add(new IconButton(gamePanel.visualMode.SunShroomCardIcon, gamePanel.visualMode.GameDim.width * 10 / 90,
            gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.SunShroomImage, gamePanel));

    plantClasses.add(PuffShroom.class);
    cards.add(new IconButton(gamePanel.visualMode.PuffShroomCardIcon, gamePanel.visualMode.GameDim.width * 46 / 90,
            gamePanel.visualMode.GameDim.height / 67, gamePanel.visualMode.PuffShroomImage, gamePanel));
  }
}
