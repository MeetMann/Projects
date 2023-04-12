/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 4
Class: Path
*/
import java.util.*;
public class Path {
  private int x_coord;
  private int y_coord;

  public Path(int x_coord, int y_coord) {
    this.x_coord = x_coord;
    this.y_coord = y_coord;
  }

   public int getX_Coord() {
    return this.x_coord; 
  }
  public int getY_Coord() {
    return this.y_coord; 
  }
}