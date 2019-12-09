package remake.etc;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import remake.GameMode.Visuals.VisualMode;
import remake.entities.plants.Plant;

public interface CellsManager {

  int[] cols = new int[9];
  int[] lanes = new int[5];
  int total_cells = cols.length * lanes.length;
  ArrayList<Point> gridPoints = new ArrayList<>(total_cells);
  ArrayList<Rectangle> cells = new ArrayList<>(total_cells);
  Map<Point, Plant> cellMaps = new HashMap<>();

  static void init(VisualMode visualMode) {
    cols[0] = visualMode.GameDim.width * 5 / 89;
    cols[1] = visualMode.GameDim.width * 14 / 89;
    cols[2] = visualMode.GameDim.width * 23 / 89;
    cols[3] = visualMode.GameDim.width * 32 / 89;
    cols[4] = visualMode.GameDim.width * 41 / 89;
    cols[5] = visualMode.GameDim.width * 50 / 89;
    cols[6] = visualMode.GameDim.width * 59 / 89;
    cols[7] = visualMode.GameDim.width * 68 / 89;
    cols[8] = visualMode.GameDim.width * 77 / 89;

    lanes[0] = visualMode.GameDim.height * 12 / 67;
    lanes[1] = visualMode.GameDim.height * 23 / 67;
    lanes[2] = visualMode.GameDim.height * 34 / 67;
    lanes[3] = visualMode.GameDim.height * 45 / 67;
    lanes[4] = visualMode.GameDim.height * 56 / 67;

    for (int col : cols) {
      for (int lane : lanes) {
        Point tmp = new Point(col, lane);
        gridPoints.add(tmp);
        cells.add(new Rectangle(tmp, visualMode.cellSize));
      }
    }
  }
}
