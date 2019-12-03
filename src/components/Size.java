package components;

import components.Base.Component;

public class Size extends Component {

  private int width = 0;
  private int height = 0;

  public Size() {
    super();
  }

  public Size(int width, int height) {
    super();
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
