package components;

import components.Base.Component;

public class Position extends Component {

  private int x = 0;
  private int y = 0;

  public Position() {
    super();
  }

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }
}

