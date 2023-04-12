/*
Prabhmeet Mann
B00924931
CSCI 1110 Assignment 2
Class: Main
*/

import java.util.ArrayList;
import java.util.Scanner;
public class Car_Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Array to store car models
        CarModel[] car_models = new CarModel[100];  
        // Array to store cars
        Car[] cars = new Car[100]; 
        // Array to store trips
        Trips[] trips = new Trips[100]; 
        int modelIndex = 0;
        int carIndex = 0;
        int tripIndex = 0;

        while (in.hasNext()) {
          // Taking in keyword (such as "MODEL" or "CAR")
            String checker = in.next(); 
            // If keyword is "MODEL"
            if (checker.equals("MODEL")) { 
                String modelName = in.next();
                float fuelEconomy = in.nextFloat();
                float tankCapacity = in.nextFloat();
                car_models[modelIndex] = new CarModel(modelName, fuelEconomy, tankCapacity);
                modelIndex++;
            }
            // If keyword is "CAR"
            else if (checker.equals("CAR")) { 
                String model_Name = in.next();
                int plateNumber = in.nextInt();
                // For loop to link the Car to a specific model
                for (int i = 0; i < modelIndex; i++) {  
                    if (car_models[i].getModelName().equals(model_Name)) {
                        cars[carIndex] = new Car(car_models[i], plateNumber);
                        carIndex++;
                        break;
                    }
                }
            }
            // If keyword is "TRIP"
            else if (checker.equals("TRIP")) {  
                int plateNumber = in.nextInt();
                int distance = in.nextInt();
                for (int i = 0; i < carIndex; i++) {
                  // Variable that calculates fuel consumption
                    double trip_calc = (distance / 100.0) * cars[i].getModel().getfuelEco(); 
                    // If plate number of car matches plate number in input
                    if (cars[i].getPlateNumber() == plateNumber) { 
                        // If the car has enough fuel to make the trip
                        if (cars[i].getcurrentFuel() >= trip_calc) { 
                        // Set the new value for current fuel after the trip
                            cars[i].setcurrentFuel(cars[i].getcurrentFuel() - trip_calc); 
                            System.out.println("Trip completed successfully for #" + plateNumber);
                            // Storing every successful trip in trips array
                            trips[tripIndex] = new Trips(plateNumber, distance); 
                            tripIndex++;
                            break;
                        }
                        // Otherwise, the car did not have enough fuel
                        else { 
                            System.out.println("Not enough fuel for #" + plateNumber);
                            cars[i].setcurrentFuel(cars[i].getcurrentFuel() - trip_calc);
                        }
                    }
                }
            }
            // If keyword is "REFILL"
            else if (checker.equals("REFILL")) { 
                int plateNumber = in.nextInt();
                for (int i = 0; i < carIndex; i++) {
                  // Compare plate numbers once again
                    if (cars[i].getPlateNumber() == plateNumber) { 
                    // Use refill method
                        cars[i].refill(); 
                        break;
                    }
                }
            }
            // If keyword is "FINISH"
            else if (checker.equals("FINISH")) { 
                break;
            }
            // If keyword is "LONGTRIPS"
            else if (checker.equals("LONGTRIPS")) { 
                int plateNumber = in.nextInt();
                int distance = in.nextInt();
                // Counter to count the amount of longtrips
                int trip_counter = 0;  
                // For loop checking for longtrips
                for (int i = 0; i<tripIndex; i++) { 
                    if (trips[i].getplate_Number() == plateNumber) {
                      // If distance of trip is greater than distance specified in longtrips
                        if (trips[i].getDistance() >= distance) { 
                            trip_counter++;
                        }
                    }
                }
                System.out.println("#" + plateNumber + " made " + trip_counter + " trips longer than " + distance);
            }
        }
    }
}