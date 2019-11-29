package entity;

import component.Collision;
import component.Damage;
import component.Health;
import component.Move;
import component.Position;
import component.Size;
import java.util.ArrayList;
import java.util.List;

public class Pea extends RootEntity implements Move {

  private int speed;

  /*
   * Initialize a bullet with a given position
   * This is used to initialize the bullet when it is first spawn from a Plant
   */
  public Pea(int x, int y, int speed, int damage) {
    this.speed = speed;
    this.addComponent(new Collision(new ArrayList<>(List.of(Zombie.class))));
    this.addComponent(new Size(10, 10));
    this.addComponent(new Position(x, y));
    this.addComponent(new Damage(damage));
  }

  //move by increasing x, assume that the map x-coordinate is numbered from left to right,
  //y-coordinate is number from bottom to top
  public void move() {
    Position pos = this.getSingleComponent(Position.class);
    pos.setX(pos.getX() + speed);
  }

  public void attackOnCollision(RootEntity opponent) {
    int damage = this.getSingleComponent(Damage.class).getOn_collision_cause_damage();
    opponent.getSingleComponent(Health.class).reduceHealthOnDamaged(-Math.abs(damage));
  }
}
