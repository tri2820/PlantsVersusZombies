package entity;

import javax.swing.*;
import java.awt.*;

//maybe ConeHeadZombie will implement another attack method which cause opponent to reduce more health
public class ConeHeadZombie extends Zombie {

    public ConeHeadZombie(int x, int y, int health, int speed, int damage) {
        super(x, y, health, speed, damage);
    }
}
