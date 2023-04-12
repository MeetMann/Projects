/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 2
Class: Trips
*/

public class Trips {
    // Attributes of trips that would help identify a specific trip and aid with calculation of longtrips
    private int plateNumber;
    private int Distance;
    
    // Constructor
    public Trips(int plateNumber, int Distance) {
        this.plateNumber = plateNumber;
        this.Distance = Distance;
    }
    
    // Getters
    public int getplate_Number() {
        return plateNumber;
    }

    public int getDistance() {
        return Distance;
    }
}
