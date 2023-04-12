/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 4
Class: Bottle
*/
import java.util.*;
public class Bottle { 
  private String name;
  private int initial_x_coord;
  private int initial_y_coord;
  private String message; 
  private Stack<Path> path;

  public Bottle(String name, int initial_x_coord, int initial_y_coord, String message) {
    this.name = name;
    this.initial_x_coord = initial_x_coord;
    this.initial_y_coord = initial_y_coord;
    this.message = message; 
    path = new Stack<Path>();
  }

  public String getName() {
    return this.name; 
  }
  public int getInitial_X_Coord() {
    return this.initial_x_coord; 
  }
  public int getInitial_Y_Coord() {
    return this.initial_y_coord; 
  }
  public String getMessage() {
    return this.message; 
  }
  public void addPath(Path p) {
    path.push(p);
  }
  public Path getPath() {
   return path.pop();
  }
  public Path viewPath() {
    return path.peek();
  }
  public int getPathSize() {
    return path.size();
    }
}