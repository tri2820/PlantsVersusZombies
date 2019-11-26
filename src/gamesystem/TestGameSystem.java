package gamesystem;

public class TestGameSystem extends GameSystem {

  private static TestGameSystem test_game_system = null;

  private TestGameSystem() {
    super();
  }

  static public TestGameSystem getSingleton() {
    if (test_game_system == null) {
      test_game_system = new TestGameSystem();
    }
    return test_game_system;
  }

  @Override
  public void step() {
    this.elapsed_step++;
    var collisions = GameSystemUtils.getCollisions(this.entities());
    GameSystemUtils.reduceHealthOnCollision(collisions, true);
  }
}