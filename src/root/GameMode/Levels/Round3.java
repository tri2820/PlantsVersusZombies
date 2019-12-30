package root.GameMode.Levels;

import root.GUI.GamePanel;
import root.GameMode.Visuals.NightMode;

public class Round3 extends Round2 {

  public Round3(GamePanel gamePanel) {
    super(gamePanel);
    gamePanel.visualMode = new NightMode();
  }
}
