package root.entities.moveable;

import root.entities.zombies.Zombie;
import java.awt.*;

public class KillSun extends MoveableObjects {
    //kill all the zombie on the gamepanel
    public static int existLoop = 20;
    public boolean collected = false;
    public boolean doneCollected = false;

    public KillSun(int x, int y) {
        super(x, y);
        dx = 2;
        dy = 12;
    }

    public void SpecialMoves() {
        if (position.y == visualMode.GameDim.height - getImage().getHeight(null)) {
            dy = 0;
            LoopCounter++;
        }
    }

    public void CollectedAction() {
        for (Zombie zombie : gamePanel.level.zombies) {
            zombie.health = 0;
        }
        doneCollected = true;
    }

    @Override
    public void actions() {
        move();
        if(collected) {
            CollectedAction();
        } else {
            SpecialMoves();
        }
    }

    @Override
    public Image getImage() {
        return visualMode.KillSunImage;
    }
}
