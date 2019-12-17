package root.entities.stuffs;

public class HeadedSun extends Sun {

  protected int initialX;
  protected int initialY;
  protected int initial_dY;
  private boolean topped = false;

  public HeadedSun(int x, int y) {
    super(x, y);
    initialX = x;
    initialY = y;
    if (dy > 0) {
      dy *= -1;
    }
    initial_dY = 2 * dy;
  }

  @Override
  public void SpecialMoves() {
    if (position.y <= (-visualMode.GameDim.height / 20 + initialY) && dy < 0) {
      dy = -initial_dY;
    } else if (position.y >= initialY && dy >= 0) {
      dy = 0;
      LoopCounter++;
    }
  }
}
