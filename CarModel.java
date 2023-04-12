/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 2
Class: CarModel
*/

public class CarModel {
    // Attributes of a Car Model
    private String modelName;
    private float fuelEco;
    private float tankCapacity;

    // Constructor
    public CarModel(String modelName, float fuelEco, float tankCapacity) {
        this.modelName = modelName;
        this.fuelEco = fuelEco;
        this.tankCapacity = tankCapacity;
    }

    // Getters
    public String getModelName() {
        return modelName;
    }

    public double getfuelEco() {
        return fuelEco;
    }

    public double gettankCapacity() {
        return tankCapacity;
    }
}