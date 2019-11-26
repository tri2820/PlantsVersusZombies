package component;

public class Damage extends Component {

  private int on_collision_cause_damage;

  public Damage(int on_collision_cause_damage) {
    this.on_collision_cause_damage = on_collision_cause_damage;
  }

  public int getOn_collision_cause_damage() {
    return on_collision_cause_damage;
  }
}
