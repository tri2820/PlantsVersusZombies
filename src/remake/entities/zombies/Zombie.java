package remake.entities.zombies;

import remake.entities.GameEntity;
import remake.entities.plants.Plant;
import remake.etc.CellsManager;

public abstract class Zombie extends GameEntity {

  public int health;
  public boolean stunt = false;

  public Zombie(int x, int y) {
    super(x, y);
    dx = -1;
    dy = 0;
  }

  @Override
  public void actions() {
    LoopCounter++;
    position.y += dy;

    Plant collidedPlant = collidedPlant();
    if (collidedPlant == null) {
      if (!stunt) {
        position.x += dx;
      } else {
        if (LoopCounter % 40 == 0) {
          stunt = false;
        }
      }
    } else {
      collidedPlant.health -= 1;
    }
  }

  private Plant collidedPlant() {
    if (!CellsManager.cellMaps.isEmpty()) {
      for (Plant p : CellsManager.cellMaps.values()) {
        if (position.x == p.getX() + p.getImage().getWidth(null) && position.y + visualMode.GameDim.height / 67 == p.getY()) {
          return p;
        }
      }
    }
    return null;
  }
}
