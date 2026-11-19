import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Constant
        final double DRINK_PRICE = 15.50;

        // Variables
        String customerName;
        int age;
        double mealPrice;
        int numberOfDrinks;
        boolean isStudent;
        int serviceRating;

        double drinksCost;
        double subtotal;
        double discountRate = 0.0;
        double discountAmount;
        double tipAmount;
        double finalBill;
        int wholeAmount;

        // Collect customer information
        System.out.print("Enter customer's name: ");
        customerName = input.nextLine();

        System.out.print("Enter customer's age: ");
        age = input.nextInt();

        System.out.print("Enter meal price: $");
        mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        numberOfDrinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        serviceRating = input.nextInt();

        // Validate service rating
        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5.");
        } else if (age < 0 || mealPrice < 0 || numberOfDrinks < 0) {
            System.out.println("Error: Age, meal price, and number of drinks cannot be negative.");
        } else {

            // Calculate drinks and subtotal
            drinksCost = numberOfDrinks * DRINK_PRICE;
            subtotal = mealPrice + drinksCost;

            // Select only the larger applicable discount
            if (isStudent && age >= 60) {
                discountRate = 0.10;
            } else if (isStudent) {
                discountRate = 0.10;
            } else if (age >= 60) {
                discountRate = 0.05;
            } else {
                discountRate = 0.0;
            }

            discountAmount = subtotal * discountRate;

            // Add a 10% tip for ratings of 4 or 5
            if (serviceRating == 4 || serviceRating == 5) {
                tipAmount = subtotal * 0.10;
            } else {
                tipAmount = 0.0;
            }

            // Calculate final bill
            finalBill = subtotal - discountAmount + tipAmount;

            // Type casting: remove cents
            wholeAmount = (int) finalBill;

            // Display receipt
            System.out.println("\n========== SMART RESTAURANT ==========");
            System.out.println("Customer: " + customerName);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);
            System.out.println("======================================");
        }

        input.close();
    }
}
