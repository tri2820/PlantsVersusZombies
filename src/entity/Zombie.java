package entity;

import component.Collision;
import component.Health;
import component.Position;
import component.Size;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zombie extends Entity {
    private String sprite = "";

    /*
     * Initialize with sprite folder path given
     */
    public Zombie(String sprite) {
        this.sprite = sprite;
        this.addComponent(new Collision(
                new ArrayList<>(List.of(Zombie.class, Plant.class, Bullet.class))
        ));

        this.addComponent(new Position(0, 0));
        this.addComponent(new Size(10, 10));
        this.addComponent(new Health(50, -7));
    }

    /*
     * Initialize a bullet with a given position
     * This is used to initialize the bullet when it is first spawn from a Plant
     */
    public Zombie(String sprite, int x, int y) {
        this(sprite);
        this.removeComponent(Position.class);
        this.addComponent(new Position(x, y));
    }

    //move by decreasing x, assume that the map x-coordinate is numbered from left to right,
    //y-coordinate is number from bottom to top
    public void move() {
        Position pos = getSingleComponent(Position.class);
        pos.setX(pos.getX() - 1);
    }
}


