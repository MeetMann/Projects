/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 2
Class: Car
*/

public class Car {
    // Attributes of a Car
    private CarModel model;
    private int plateNumber;
    private double currentFuel;

    // Constructor
    public Car(CarModel model, int plateNumber) {
        this.model = model;
        this.plateNumber = plateNumber;
        this.currentFuel = model.gettankCapacity(); // Setting the current fuel to the car models tank capacity
    }
    // Getters
    public CarModel getModel() {
        return model;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public double getcurrentFuel() {
        return currentFuel;
    }

    // Setters
    public void setcurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    // Method that sets the fuel tank back to maximum, used when keyword "REFILL" is present
    public void refill() {
        this.currentFuel = model.gettankCapacity();
    }
}