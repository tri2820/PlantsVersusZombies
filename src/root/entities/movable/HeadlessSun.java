package root.entities.movable;

public class HeadlessSun extends Sun {
  //sun that comes from sun
  public HeadlessSun(int x, int y) {
    super(x, y);
  }

  @Override
  public void SpecialMoves() {
    if (Math.abs(position.y - visualMode.GameDim.height + getImage().getHeight(null)) < Math.abs(dy)) {
      position.y -= dy;
      LoopCounter++;
    }
  }
}
