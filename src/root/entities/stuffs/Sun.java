package root.entities.stuffs;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class Sun extends Stuff {

  public static int Count = 0;
  public static JLabel CountLabel = new JLabel(String.valueOf(Count), SwingConstants.CENTER);
  public static int existLoop = 80;
  private static Point SunCollector =
      new Point(visualMode.GameDim.width / 90, visualMode.GameDim.height / 67);
  public boolean collected = false;
  public boolean doneCollected = false;

  public Sun(int x, int y) {
    super(x, y);
    dx = 0;
    dy = visualMode.GameDim.height / 300;
  }

  public static JLabel initCountLabel() {
    CountLabel.setBounds(
        visualMode.GameDim.width * 5 / 200, visualMode.GameDim.height * 7 / 67, 75, 30);
    if (gamePanel.testMode) {
      CountLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    CountLabel.setFont(visualMode.SOL_FONT.deriveFont(20f));
    CountLabel.setHorizontalAlignment(SwingConstants.CENTER);
    return CountLabel;
  }

  public static void updateCount(int amount) {
    CountLabel.setText(String.valueOf(Count += amount));
  }

  @Override
  public Image getImage() {
    return visualMode.SunImage;
  }

  public void CollectedAction() {
    double speed = 20;
    double length = SunCollector.distance(position);
    dx = (int) ((SunCollector.x - position.x) / length * speed);
    dy = (int) ((SunCollector.y - position.y) / length * speed);
    if (Math.abs(SunCollector.x - position.x) < 20 && Math.abs(SunCollector.y - position.y) < 20) {
      updateCount(25);
      doneCollected = true;
    }
  }

  public void SpecialMoves() {
  }

  @Override
  public void actions() {
    move();

    if (collected) {
      CollectedAction();
    } else {
      SpecialMoves();
    }
  }
}
