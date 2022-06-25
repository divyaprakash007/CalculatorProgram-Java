import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

           Main main  = new Main();  // Main method object for accessing private methods;
           String numbers = "";
           String operation = "";

           // While loop to get and validate user input.
           do{
               System.out.println("Please enter two Integer Numbers");
               numbers = main.systemInput();
           } while(!main.validateNumbers(numbers));

           // Split both numbers in arrays, to calculate further
           String[] splitNumber = numbers.split(" ");

           // Ask user to input a valid operation to perform on given numbers.
           do{
               System.out.println("Please enter Valid operation ( + - * / x)");
                operation = main.systemInput();
           } while(!main.validateOperation(operation));
            int num1 = Integer.parseInt(splitNumber[0]);
            int num2 = Integer.parseInt(splitNumber[1]);

            // Good use of enhance switch case, specially not using the BREAK; statement
            //Also, checking more than one condition in switch Ex : Case 3
        switch (operation) {
            case "+" -> System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
            case "-" -> System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
            case "*", "x", "X" -> System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
            case "/" -> System.out.println(num1 + " / " + num2 + " = " + ((double) num1 / num2));
            default -> {
                System.out.println("Something went wrong !");
                System.out.println("Program terminated.");
                System.exit(0);
            }
        }
            //ANSI keys for change text colour on console. also reset the colour default.
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println("Calculate more...");
        System.out.println(ANSI_YELLOW+ "Press 1 -> Yes" + ANSI_RESET);
        System.out.println("Press any key -> No");

        int option = Integer.parseInt(main.systemInput());
            // Check if user entered 1 then repeat process, otherwise exit the program.
        if (option!=1) System.exit(0);

        // Restarting main method again.
        Main.main(args);

    }

    private boolean validateOperation(String operation) {
        String opeChars = "+-*/xX";
        return opeChars.contains("" + operation.charAt(0));
    }

    private String systemInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private boolean validateNumbers(String numbers) {
        if (numbers.contains("exit")) {
            System.out.println("Program closed.");
            System.exit(0);
        }
        String[] array = numbers.split(" ");
        return array.length == 2;
    }
}