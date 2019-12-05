//package minimalRemake.GUI;
//
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.io.File;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//public class Game_Old extends JPanel implements Runnable, MouseListener, MouseMotionListener {
//
//  private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//  private final int DELAY = 25;
//  // TEMP
//  int x, pea_pos;
//  int mouseX, mouseY;
//  // flags
//  boolean cardPeaShooterClicked = false;
//  boolean cardSunFlowerClicked = false;
//  boolean cardFreezePeaShooterClicked = false;
//  String ProjectDir = new File("").getAbsolutePath();
//  String resourceDir = ProjectDir + "/resource/";
//  Image bg, pea, sun, zom1, zom2, freezepeashooter, peashooter, sunflower;
//  ImageIcon card_cherrybomb, card_freezepeashooter, card_peashooter, card_sunflower, card_wallnut;
//  JButton cherrybombBT, freezepeaseshooterBT, peashooterBT, sunflowerBT, wallnutBT;
//  private Dimension GameDim;
//  // x-pos of each lane
//  private int lane1y, lane2y, lane3y, lane4y, lane5y;
//  private Thread animator;
//
//
//  public Game_Old() {
//    initGame();
//    addMouseListener(this);
//    addMouseMotionListener(this);
//
//    setLayout(null);
//    add(sunflowerBT = new IconButton(card_sunflower, GameDim.width * 10 / 90, GameDim.height * 1 / 67, this));
//    add(peashooterBT = new IconButton(card_peashooter, GameDim.width * 16 / 90, GameDim.height * 1 / 67, this));
//    add(wallnutBT = new IconButton(card_wallnut, GameDim.width * 22 / 90, GameDim.height * 1 / 67, this));
//    add(freezepeaseshooterBT = new IconButton(card_freezepeashooter, GameDim.width * 28 / 90, GameDim.height * 1 / 67, this));
//    add(cherrybombBT = new IconButton(card_cherrybomb, GameDim.width * 34 / 90, GameDim.height * 1 / 67, this));
//
//    peashooterBT.addMouseMotionListener(this);
//    sunflowerBT.addMouseMotionListener(this);
//    wallnutBT.addMouseMotionListener(this);
//    freezepeaseshooterBT.addMouseMotionListener(this);
//    cherrybombBT.addMouseMotionListener(this);
//  }
//
//  private void initGame() {
//    bg = new ImageIcon(resourceDir + "Background.png").getImage();
//    pea = new ImageIcon(resourceDir + "Pea.png").getImage();
//    sun = new ImageIcon(resourceDir + "Sun.png").getImage();
//    zom1 = new ImageIcon(resourceDir + "zombies/NormalZombie.png").getImage();
//    zom2 = new ImageIcon(resourceDir + "zombies/ConeHeadZombie.png").getImage();
//    freezepeashooter = new ImageIcon(resourceDir + "plants/FreezePeaShooter.gif").getImage();
////    peashooter = new ImageIcon("/home/tidu-t1/Downloads/ezgif.com-resize.gif").getImage();
//    peashooter = new ImageIcon(resourceDir + "plants/PeaShooter.gif").getImage();
//    sunflower = new ImageIcon(resourceDir + "plants/SunFlower.gif").getImage();
//    card_cherrybomb = new ImageIcon(resourceDir + "/cards/card_cherrybomb.png");
//    card_freezepeashooter = new ImageIcon(resourceDir + "/cards/FreezePeaShooterCard.png");
//    card_peashooter = new ImageIcon(resourceDir + "/cards/PeaShooterCard.png");
//    card_sunflower = new ImageIcon(resourceDir + "/cards/SunFlowerCard.png");
//    card_wallnut = new ImageIcon(resourceDir + "/cards/card_wallnut.png");
//
//    // Set Game dimension based on the background image
//    GameDim = new Dimension(bg.getWidth(null), bg.getHeight(null));
//    // Set coefficient to find each lane relative to the background
//    lane1y = GameDim.height * 54 / 67;
//    lane2y = GameDim.height * 43 / 67;
//    lane3y = GameDim.height * 32 / 67;
//    lane4y = GameDim.height * 21 / 67;
//    lane5y = GameDim.height * 10 / 67;
//
//    setPreferredSize(GameDim);
//
//    // initialized tmp values
//    x = GameDim.width;
//    pea_pos = 0;
//  }
//
//  @Override
//  public void paintComponent(Graphics g) {
//    g.drawImage(bg, 0, 0, null);
//    g.drawImage(pea, pea_pos, lane1y + GameDim.height * 3 / 67, null);
//    g.drawImage(pea, pea_pos, lane2y + GameDim.height * 3 / 67, null);
//    g.drawImage(pea, pea_pos, lane3y + GameDim.height * 3 / 67, null);
//    g.drawImage(pea, pea_pos, lane4y + GameDim.height * 3 / 67, null);
//    g.drawImage(pea, pea_pos, lane5y + GameDim.height * 3 / 67, null);
//    g.drawImage(sun, 0, 0, null);
//    g.drawImage(zom1, x, lane1y, null);
//    g.drawImage(zom1, x, lane2y, null);
//    g.drawImage(zom1, x, lane3y, null);
//    g.drawImage(zom1, x, lane4y, null);
//    g.drawImage(zom1, x, lane5y, null);
//    g.drawImage(peashooter, GameDim.width * 1 / 9, lane1y + GameDim.height * 2 / 67, null);
//    g.drawImage(peashooter, GameDim.width * 1 / 9, lane2y + GameDim.height * 2 / 67, null);
//    g.drawImage(peashooter, GameDim.width * 1 / 9, lane3y + GameDim.height * 2 / 67, null);
//    g.drawImage(peashooter, GameDim.width * 1 / 9, lane4y + GameDim.height * 2 / 67, null);
//    g.drawImage(peashooter, GameDim.width * 1 / 9, lane5y + GameDim.height * 2 / 67, null);
//    if (cardPeaShooterClicked) {
//      g.drawImage(peashooter, mouseX, mouseY, null);
//    }
//    if (cardSunFlowerClicked) {
//      g.drawImage(sunflower, mouseX, mouseY, null);
//    }
//    if (cardFreezePeaShooterClicked) {
//      g.drawImage(freezepeashooter, mouseX, mouseY, null);
//    }
////    g.drawImage(zom2, 0, 0, null);
////    g.drawImage(freezepeashooter, 100, 100, null);
////    g.drawImage(peashooter, 100, 100, null);
////    g.drawImage(sunflower, 0, 0, null);
////    g.drawImage(card_cherrybomb, GameDim.width/2, GameDim.height*1/67, null);
//  }
//
//  private void cycle() {
//    x -= 1;
//    pea_pos += 5;
//    if (x <= 0) {
//      x = GameDim.width;
//    }
//    if (pea_pos >= GameDim.width) {
//      pea_pos = 0;
//    }
//  }
//
//  @Override
//  public void addNotify() {
//    super.addNotify();
//
//    animator = new Thread(this);
//    animator.start();
//  }
//
//
//  public void run() {
//    long beforeTime, timeDiff, sleep;
//
//    beforeTime = System.currentTimeMillis();
//
//    while (true) {
//
//      cycle();
//      repaint();
//
//      timeDiff = System.currentTimeMillis() - beforeTime;
//      sleep = DELAY - timeDiff;
//
//      if (sleep < 0) {
//        sleep = 2;
//      }
//
//      try {
//        Thread.sleep(sleep);
//      } catch (InterruptedException e) {
//
//        String msg = String.format("Thread interrupted: %s", e.getMessage());
//
//        JOptionPane.showMessageDialog(this, msg, "Error",
//            JOptionPane.ERROR_MESSAGE);
//      }
//
//      beforeTime = System.currentTimeMillis();
//    }
//  }
//
//  @Override
//  public void mouseClicked(MouseEvent m) {
//  }
//
//  @Override
//  public void mousePressed(MouseEvent m) {
//  }
//
//  @Override
//  public void mouseReleased(MouseEvent m) {
//
//  }
//
//  @Override
//  public void mouseEntered(MouseEvent m) {
//
//  }
//
//  @Override
//  public void mouseExited(MouseEvent m) {
//
//  }
//
//  @Override
//  public void mouseDragged(MouseEvent mouseEvent) {
//    cardPeaShooterClicked = mouseEvent.getSource() == peashooterBT;
//
//    cardSunFlowerClicked = mouseEvent.getSource() == sunflowerBT;
//
//    cardFreezePeaShooterClicked = mouseEvent.getSource() == freezepeaseshooterBT;
//
//    mouseX = mouseEvent.getX();
//    mouseY = mouseEvent.getY();
//    repaint();
//  }
//
//  @Override
//  public void mouseMoved(MouseEvent mouseEvent) {
//
//  }
//}
