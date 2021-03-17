package com.sap;

import com.sap.shapes.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continuePlay = true;
        boolean isValidOption = false;
        String formula = "formula";
        String shape = "shape";


        Scanner scanner = new Scanner(System.in);

        while (continuePlay) {
            shape = getValidInput(scanner, shape, "circle, rectangle or exit (to end the program)");
            formula = getValidInput(scanner, formula, "area or perimeter or exit (to end the program)");

            System.out.printf("You have chosen the to calculate the %s of %s.%n", formula, shape);
            calculateResult(scanner, shape, formula);

            System.out.println("Do you want to play again? Please type YES to continue.");
            continuePlay = checkIfValidOption(scanner.nextLine());
        }
        System.out.println("OK, thank you for using this program. Have a nice day!");
        scanner.close();
    }

    private static void calculateResult(Scanner scanner, String shape, String formula) {
        double result = 0.0;
        switch (shape) {
            case "circle":
                calculateCircleFormula(scanner,formula);
                break;
            case "rectangle":
                calculateRectangleFormula(scanner,formula);
                break;
            default:
                System.out.println("We are unable to calculate this at the moment. Please try again later.");
        }
    }

    /**
     * Get from the user the input, check if it is valid input and then return it if it is valid.
     *
     * @param scanner
     * @param type
     * @param options
     * @return valid user input as a String
     */
    private static String getValidInput(Scanner scanner, String type, String options) {
        boolean isValidOption = false;
        while (!isValidOption) {
            System.out.printf("What %s do you want to calculate? %n", type);
            System.out.printf("Please choose between: %s %n", options);

            type = scanner.nextLine().toLowerCase();
            isValidOption = checkIfValidOption(type);
            if (!isValidOption) {
                System.out.println("You have selected " + type + " which is not available. Please, try again");
            }
        }
        return type;
    }

    private static void calculateRectangleFormula(Scanner scanner, String formula) {
        double result = 0.0;
        System.out.println("Please enter the length value");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the width value");
        double width = Double.parseDouble(scanner.nextLine());
        Shape shape = new Rectangle(length, width);

        result = getResult(formula, shape);
        System.out.printf("The %s of the rectangle is: %f %n", formula, result);
    }

    private static void calculateCircleFormula(Scanner scanner, String formula) {
        double result = 0.0;
        System.out.println("Please enter a the radius value");
        double radius = Double.parseDouble(scanner.nextLine());
        Shape object = new Circle(radius);

        result = getResult(formula, object);
        System.out.printf("The %s of the circle is: %f %n", formula, result);
    }

    private static double getResult(String formula, Shape shape) {
        double result = 0.0;
        if (formula.equalsIgnoreCase("area")) {
            return shape.getArea();
        } else if (formula.equalsIgnoreCase("perimeter")) {
            return shape.getPerimeter();
        }
        return result;
    }

    private static boolean checkIfValidOption(String selectedOption) {
        boolean isVald = false;
        switch (selectedOption) {
            case "exit":
                System.out.println("Good bye!");
                System.exit(0);
                break;
            case "circle":
            case "rectangle":
            case "area":
            case "perimeter":
            case "yes":
            case "no":
                isVald = true;
            default:
        }
        return isVald;
    }
}
