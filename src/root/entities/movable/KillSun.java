package root.entities.movable;

import java.awt.Image;
import java.util.Random;
import root.entities.zombies.Zombie;

public class KillSun extends Sun {

    //lasting time of the kill sun
    public static final int existLoop = 100;
    private static final int bound = 30;
    private static Random rand = new Random();
    public boolean clicked = false;

    //kill all the zombie on the gamePanel
    public KillSun(int x, int y) {
        super(x, y);
        generateMove();
    }

    private void generateMove() {
        dx = rand.nextInt(bound) - bound * 1.0 / 2;
        dy = rand.nextInt(bound) - bound * 1.0 / 2;
    }

    @Override
    public void SpecialMoves() {
//        LoopCounter++;
        if (position.x <= 0 || position.x + getImage().getWidth(null) >= visualMode.GameDim.width) {
            dx *= -1;
//            dy = rand.nextInt(bound) - bound * 1.0 / 2;
        } else if (position.y <= 0
                || position.y + getImage().getHeight(null) >= visualMode.GameDim.height) {
            dy *= -1;
//            dx = rand.nextInt(bound) - bound * 1.0 / 2;
        }
    }

    @Override
    public void CollectedAction() {
        for (Zombie zombie : gamePanel.level.zombies) {
            zombie.health = 0;
            System.out.println("you clicked");
        }
        doneCollected = true;
    }

    @Override
    public Image getImage() {
        return visualMode.KillSunImage;
    }
}
