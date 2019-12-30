package root.entities.movable;

import java.awt.Image;
import root.entities.zombies.Zombie;

public class KillSun extends Sun {

    //kill all the zombie on the gamePanel
    public KillSun(int x, int y) {
        super(x, y);
        dx = 4;
        dy = 24;
    }

    @Override
    public void SpecialMoves() {
        if (position.y == visualMode.GameDim.height - getImage().getHeight(null)) {
            dy = 0;
            LoopCounter++;
        }
    }

    @Override
    public void CollectedAction() {
        for (Zombie zombie : gamePanel.level.zombies) {
            zombie.health = 0;
        }
        doneCollected = true;
    }

    @Override
    public Image getImage() {
        return visualMode.KillSunImage;
    }
}
