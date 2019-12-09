package remake.GameMode.Levels;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import remake.GUI.GamePanel;
import remake.GUI.IconButton;
import remake.GameMode.Visuals.VisualMode;
import remake.entities.GameEntity;
import remake.entities.plants.Plant;
import remake.entities.stuffs.Stuff;
import remake.entities.zombies.Zombie;
import remake.etc.CellsManager;

public abstract class Level {

  public LinkedList<Stuff> stuffs = new LinkedList<>();
  public LinkedList<Zombie> zombies = new LinkedList<>();
  public ArrayList<Class<? extends Plant>> plantClasses = new ArrayList<>();
  public ArrayList<Class<? extends Zombie>> zombieClasses = new ArrayList<>();
  public ArrayList<IconButton> cards = new ArrayList<remake.GUI.IconButton>(5);

  public int MAX_ZOMBIES;
  public int zombieCount = 0;
  public boolean gameOver = false;

  public Level(GamePanel gamePanel) {
    GameEntity.setGamePanel(gamePanel);
    GameEntity.setVisualMode();
  }

  public boolean end() {
    return zombieCount >= MAX_ZOMBIES;
  }

  public void addZombie(VisualMode visualMode) {
    for (Class<? extends Zombie> zombieClass : zombieClasses) {
      try {
        zombies.add(zombieClasses.get(new Random().nextInt(zombieClasses.size())).getConstructor(int.class, int.class)
            .newInstance(visualMode.GameDim.width + 10, CellsManager.lanes[new Random().nextInt(5)] - visualMode.GameDim.height / 67));
        zombieCount++;
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
  }
}
