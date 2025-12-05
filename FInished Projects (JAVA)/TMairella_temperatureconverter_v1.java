/*
* NAME: Thomas Mairella
* DATE: // 9/26/25
* VERSION: // v1
* SOURCES USED: // 
* COMMENTS / NOTES:
* - This is my temperature converter, It can convert ANY form of degrees to another. It has all three forms
    of degrees including fahrenheit, celsius, and kelvin. It also includes a Absolute Zero function where 
    it gives an error if too cold.
* - Instructions: Just run the program and follow the instructions, and make sure to not use a non-numeric 
    number or any other characters besides C, F, or K.
*/

import java.util.Scanner;

public class TMairella_temperatureconverter_v1 {
    public static void main(String[] args) {

         // Variables
        double temp;
        char ogtype;
        char newtype;

        // New Scanner to ask user for inputs
        Scanner input = new Scanner(System.in);  
        System.out.println("Welcome, This is a Temperature Converter!");
        System.out.print("Enter your temperature: ");
        temp = input.nextDouble();
        System.out.print("Enter your temperature type (C, F, K): ");
        ogtype = input.next().toUpperCase().charAt(0);
        System.out.print("Enter your new temperature type (C, F, K): ");
        newtype = input.next().toUpperCase().charAt(0);

        // All Conversion Methods
        if (ogtype == 'C' && newtype == 'F') {
            temp = (temp * 9/5) + 32;
            if (temp < -459.66999999999996) {
                System.out.println("Warning: The resulting temperature is below absolute zero (0°K), which is not physically possible.");
            } else if (temp > -459.66999999999996) {
                System.out.println("Your temperature is: " + temp + "°F");
            }
        } else if (ogtype == 'F' && newtype == 'C') {
            temp = (temp - 32) * 5/9;
            if (temp < -273.15) {
                System.out.println("Warning: The resulting temperature is below absolute zero (0°K), which is not physically possible.");
            } else if (temp > -273.15) {
                System.out.println("Your temperature is: " + temp + "°C");
            }
        } else if (ogtype == 'C' && newtype == 'K') {
            temp = (temp + 273.15);
            if (temp < 0) {
                System.out.println("Warning: The resulting temperature is below absolute zero (0°K), which is not physically possible.");
            } else if (temp > 0) {
                System.out.println("Your temperature is: " + temp + "°K");
            }
        } else if (ogtype == 'K' && newtype == 'C') {
            temp = (temp - 273.15);
            if (temp < -273.15) {
                System.out.println("Warning: The resulting temperature is below absolute zero (0°K), which is not physically possible.");
            } else if (temp > -273.15) {
                System.out.println("Your temperature is: " + temp + "°C");
            }
        } else if (ogtype == 'F' && newtype == 'K') {
            temp = ((temp - 32) * 5/9) + 273.15;
            if (temp < 0) {
                System.out.println("Warning: The resulting temperature is below absolute zero (0°K), which is not physically possible.");
            } else if (temp > 0) {
                System.out.println("Your temperature is: " + temp + "°K");
            }
        } else if (ogtype == 'K' && newtype == 'F') {
            temp = ((temp - 273.15) * 9/5) + 32;
            if (temp < -459.66999999999996) {
                System.out.println("Warning: The resulting temperature is below absolute zero (0°K), which is not physically possible.");
            } else if (temp > -459.66999999999996) {
                System.out.println("Your temperature is: " + temp + "°F");
            }
        } else {
            System.out.println("Invalid input. Please enter a CAPITAL C, F, or K for temperature types.");
        }
        input.close();
    }
}
