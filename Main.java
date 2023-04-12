/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 4
Class: Problem2
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mapLength = in.nextInt();
        int mapWidth = in.nextInt();
        String[][] earth_map = new String[mapLength][mapWidth];

       // Initializing the entire map with "O"
    for (int i = 0; i<mapLength; i++) {
        for (int j = 0; j<mapWidth; j++) {
            earth_map[i][j] = "O";
        }
    }

    // Initializing the land_location variable
    String land_location = "temp";

    // Loop for adding coordinates to the map
    while (in.hasNext()) {
        land_location = in.next();
        if (!land_location.contains(",")) {
            break;
        }
        String[] land_coord = land_location.split(",");
        int land_x = Integer.parseInt(land_coord[0]);
        int land_y = Integer.parseInt(land_coord[1]);
        earth_map[land_x][land_y] = "X";
    }

    // Initializing the inserted variable
    boolean inserted = false; 

    // Loop for inserting bottles into the map
    while(!in.hasNextInt()) {
        for (int i = 0; i<mapLength; i++) {
            for (int j = 0; j<mapWidth; j++) {
                if (earth_map[i][j].equals("O") && inserted == false) {
                    earth_map[i][j] = land_location;
                    inserted = true; 
                }
                else if (earth_map[i][j].equals("O") && inserted == true) {
                    earth_map[i][j] = in.next();
                }
            }
        }
    }
   
    // Taking input for the number of bottles
    int num_bottles = in.nextInt(); 
    
    // Creating an array to store Bottle objects
    Bottle[] bottles = new Bottle[num_bottles];

    // Loop for taking input for the bottles and creating Bottle objects
    for (int i = 0; i<num_bottles; i++) {
        int x_coord = in.nextInt();
        int y_coord = in.nextInt();
        String name = in.nextLine();
        String message = in.nextLine();
        bottles[i] = new Bottle(name, x_coord, y_coord, message);
    }
    
    // Printing the starting coordinates of the bottles
    for (int i = 0; i<num_bottles; i++) {
        System.out.println(bottles[i].getName() + ": Starting at (" + bottles[i].getInitial_X_Coord() + ", " + bottles[i].getInitial_Y_Coord() + ")");
    }

    // Initializing the alreadyLanded array
    boolean[] alreadyLanded = new boolean[num_bottles];

  // For loop setting each bottle's path depending on its current
    for (int i = 0; i<num_bottles; i++) {
      if (earth_map[bottles[i].getInitial_X_Coord()][bottles[i].getInitial_Y_Coord()].equals("N")) {
       bottles[i].addPath(new Path(bottles[i].getInitial_X_Coord()-1, bottles[i].getInitial_Y_Coord()));
       System.out.println("0: " + bottles[i].getName() + " at (" + bottles[i].getInitial_X_Coord() + ", " + bottles[i].getInitial_Y_Coord() + "): In ocean, current taking it N.");
      }
      else if (earth_map[bottles[i].getInitial_X_Coord()][bottles[i].getInitial_Y_Coord()].equals("S")) {
       bottles[i].addPath(new Path(bottles[i].getInitial_X_Coord()+1, bottles[i].getInitial_Y_Coord()));
       System.out.println("0: " + bottles[i].getName() + " at (" + bottles[i].getInitial_X_Coord() + ", " + bottles[i].getInitial_Y_Coord() + "): In ocean, current taking it S.");
      }
        else if (earth_map[bottles[i].getInitial_X_Coord()][bottles[i].getInitial_Y_Coord()].equals("E")) {
     bottles[i].addPath(new Path(bottles[i].getInitial_X_Coord(), bottles[i].getInitial_Y_Coord()+1));
     System.out.println("0: " + bottles[i].getName() + " at (" + bottles[i].getInitial_X_Coord() + ", " + bottles[i].getInitial_Y_Coord() + "): In ocean, current taking it E.");
      }
      else if (earth_map[bottles[i].getInitial_X_Coord()][bottles[i].getInitial_Y_Coord()].equals("W")) {
   bottles[i].addPath(new Path(bottles[i].getInitial_X_Coord(), bottles[i].getInitial_Y_Coord()-1));
   System.out.println("0: " + bottles[i].getName() + " at (" + bottles[i].getInitial_X_Coord() + ", " + bottles[i].getInitial_Y_Coord() + "): In ocean, current taking it W.");
      }
      else if (earth_map[bottles[i].getInitial_X_Coord()][bottles[i].getInitial_Y_Coord()].equals("X")) {
   bottles[i].addPath(new Path(bottles[i].getInitial_X_Coord(), bottles[i].getInitial_Y_Coord()));
   System.out.println("0: " + bottles[i].getName() + " at (" + bottles[i].viewPath().getX_Coord() + ", " + bottles[i].viewPath().getY_Coord() + "): LANDED!");
      System.out.println("<<MESSAGE RECEIVED: " + bottles[i].getMessage() + ">>");
      alreadyLanded[i] = true;
      }
    }

    int j = 0;
    // boolean to for if a certain bottle has landed
    boolean[] isLanded = new boolean[num_bottles];
    // For loop updating each bottle's path depending on the current
    for (int i = 0; i<100; i++) {
       if (j == num_bottles) {
        j = 0;
      }
      int step = bottles[j].getPathSize();
      if (earth_map[bottles[j].viewPath().getX_Coord()][bottles[j].viewPath().getY_Coord()].equals("N")) {
       System.out.println(step + ": " + bottles[j].getName() + " at (" + bottles[j].viewPath().getX_Coord() + ", " + bottles[j].viewPath().getY_Coord() + "): In ocean, current taking it N.");
        bottles[j].addPath(new Path(bottles[j].viewPath().getX_Coord()-1, bottles[j].viewPath().getY_Coord()));
        j++;
      }
      else if (earth_map[bottles[j].viewPath().getX_Coord()][bottles[j].viewPath().getY_Coord()].equals("S")) {
      System.out.println(step + ": " + bottles[j].getName() + " at (" + bottles[j].viewPath().getX_Coord() + ", " + bottles[j].viewPath().getY_Coord() + "): In ocean, current taking it S.");
        bottles[j].addPath(new Path(bottles[j].viewPath().getX_Coord()+1, bottles[j].viewPath().getY_Coord()));
        j++;
      }
        else if (earth_map[bottles[j].viewPath().getX_Coord()][bottles[j].viewPath().getY_Coord()].equals("E")) {
     System.out.println(step + ": " + bottles[j].getName() + " at (" + bottles[j].viewPath().getX_Coord() + ", " + bottles[j].viewPath().getY_Coord() + "): In ocean, current taking it E.");
        bottles[j].addPath(new Path(bottles[j].viewPath().getX_Coord(), bottles[j].viewPath().getY_Coord()+1));
        j++;
      }
      else if (earth_map[bottles[j].viewPath().getX_Coord()][bottles[j].viewPath().getY_Coord()].equals("W")) {
  System.out.println(step + ": " + bottles[j].getName() + " at (" + bottles[j].viewPath().getX_Coord() + ", " + bottles[j].viewPath().getY_Coord() + "): In ocean, current taking it W.");
        bottles[j].addPath(new Path(bottles[j].viewPath().getX_Coord(), bottles[j].viewPath().getY_Coord()-1));
        j++;
      }
      else if (earth_map[bottles[j].viewPath().getX_Coord()][bottles[j].viewPath().getY_Coord()].equals("X") && isLanded[j] == false && alreadyLanded[j] == false){
        System.out.println(step + ": " + bottles[j].getName() + " at (" + bottles[j].viewPath().getX_Coord() + ", " + bottles[j].viewPath().getY_Coord() + "): LANDED!");
        System.out.println("<<MESSAGE RECEIVED: " + bottles[j].getMessage() + ">>");
        isLanded[j] = true;
        j++;
      }
      else if (isLanded[j] == true && alreadyLanded[j] == false) {
        j++;
      }
    }
    }
}

