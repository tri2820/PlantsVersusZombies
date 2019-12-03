package system;

import entities.Base.Entity;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;


public abstract class GameSystem {

  int elapsed_step;
  private Instant start_time;
  private ArrayList<Entity> entities = new ArrayList<>();

  /* Init the game before stepping */
  public void init() {
    this.start_time = Instant.now();
    this.elapsed_step = 0;
  }

  /* entities-list-relevant methods */
  public ArrayList<Entity> entities() {
    return new ArrayList<>(this.entities);
  }

  public void add(Entity e) {
    this.entities.add(e);
  }

  public void remove(Entity e) {
    this.entities.remove(e);
  }

  public boolean has(Entity e) {
    return this.entities.contains(e);
  }

  /* Return elapsed time since init */
  public long elapsedTime() {
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(this.start_time, end);
    return timeElapsed.toMillis();

  }

  /* Return number of steps taken since init */
  public int elapsedStep() {
    return this.elapsed_step;
  }

  /* Supposed to be overridden */
  public void step() {
    this.elapsed_step++;
  }
}

