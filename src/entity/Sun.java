package entity;

import component.Move;

public class Sun extends Entity implements Move {
    private String sprite_path;

    public Sun(String sprite_path) {
        this.sprite_path = sprite_path;
    }

    public void move() {
    }

    public void render() {
    }
}
