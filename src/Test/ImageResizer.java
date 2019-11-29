package Test;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {

  public static void main(String... args) throws IOException {

    File input = new File("/home/tidu-t1/IdeaProjects/PlantsVersusZombies/resource/plants"
        + "/peashooter"
        + ".gif");
    BufferedImage image = ImageIO.read(input);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    BufferedImage resized = resize(image, screenSize.height, screenSize.width);

    File output = new File("/home/tidu-t1/IdeaProjects/PlantsVersusZombies/src/Test/peashooter"
        + ".gif");
    ImageIO.write(resized, "gif", output);

  }

  private static BufferedImage resize(BufferedImage img, int height, int width) {
    Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = resized.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();
    return resized;
  }

}
