package entity;

import component.Render;

public class Map implements Render {
    private String map_file = "";

    public Map(String map_file) {
        this.map_file = map_file;
    }

    public void render() {
    }
}
