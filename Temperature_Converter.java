import java.util.InputMismatchException;
import java.util.Scanner;

public class Temperature_Converter {
    public static void main(String[] args){

        boolean use = true;
        Scanner scanner = new Scanner(System.in);
        while (use) {
            try {
                System.out.println(printtitle());
                System.out.print("Enter the value of temperature you want to convert: ");
                double temperature = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("The temperature given is in Celsius(C) or Kelvin(K) or Fahrenheit(F) : ");
                String tempExpress = scanner.nextLine().toUpperCase();
                switch (tempExpress) {
                    case "C" -> {
                        if (!celsius(scanner, temperature)) {
                            continue;
                        }
                    }
                    case "K" -> {

                        if (temperature < 0) {
                            System.out.println("The input temperature isn't valid.");
                            System.out.println("Kelvin temperature cannot be a negative value.");
                            continue;
                        } else if (!kelvin(scanner, temperature)) {
                            continue;
                        }
                    }
                    case "F" -> {
                        if (!fahrenheit(scanner, temperature)) {
                            continue;
                        }
                    }
                    default -> {
                        System.out.println("Invalid temperature unit. Please enter C, K, or F.");
                        continue;
                    }
                }

                System.out.println("Do you want to use this program again?");
                System.out.print("If YES enter Y(y)   and  If NO enter N(n): ");
                String response = scanner.nextLine().toUpperCase();
                if (response.equals("Y")) {
                    use = true;
                } else if (response.equals("N")) {
                    use = false;
                    System.out.println("BYE!!!!");
                    break;
                }
                else{
                    System.out.println("Enter some valid input.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter some valid input.");
                scanner.nextLine();
            }

        }
        scanner.close();

    }
     static String printtitle(){
        return """
                
                 _____ _____ _____ _____ _____ _____ _____ _____ _____ _____ _____    _____ _____ _____ _____ _____ _____ _____ _____ _____ _____\s
                |_   _|   __|     |  _  |   __| __  |  _  |_   _|  |  | __  |   __|  |     |     |   | |  |  |   __| __  |   __|     |     |   | |
                  | | |   __| | | |   __|   __|    -|     | | | |  |  |    -|   __|  |   --|  |  | | | |  |  |   __|    -|__   |-   -|  |  | | | |
                  |_| |_____|_|_|_|__|  |_____|__|__|__|__| |_| |_____|__|__|_____|  |_____|_____|_|___|\\___/|_____|__|__|_____|_____|_____|_|___|
                
                """;
     };
    static boolean celsius(Scanner scanner,double temperature){
        System.out.println("The inputted temperature is: " + temperature +"°C");
        double temp;
        System.out.println("Which temperature value do you want to convert it into?");
        System.out.println("Kelvin(K) (or) Fahrenheit(F)");
        String temp1 = scanner.nextLine().toUpperCase();
        if(temp1.equals("K")){
            temp = temperature + 273.15;

                System.out.printf("Hence the required temperature is: %.2fK\n", temp);

        }
        else if(temp1.equals("F")){
            temp = (temperature * 9/5) + 32 ;
            System.out.printf("Hence the required temperature is: %.2f°F",temp);
        }
        else {
            System.out.println("Enter some valid input.");
            return false;
        }
        return true;
    }
    static boolean kelvin(Scanner scanner,double temperature){
        System.out.println("The inputted temperature is: " + temperature +"K");
        double temp;
        System.out.println("Which temperature value do you want to convert it into?");
        System.out.println("Celsius(C) (or) Fahrenheit(F)");
        String temp1 = scanner.nextLine().toUpperCase();
        if(temp1.equals("C")){
            temp = temperature - 273.15;
            System.out.printf("Hence the required temperature is: %.2f°C \n",temp);
        }
        else if(temp1.equals("F")){
            temp = ((temperature - 273.15) * 9/5 ) + 32;
            System.out.printf("Hence the required temperature is: %.2f°F\n",temp);
        }
        else {
            System.out.println("Enter some valid input.");
            return false;
        }
        return true;
    }
    static boolean fahrenheit(Scanner scanner,double temperature){
        System.out.println("The inputted temperature is: " + temperature +"°F");
        double temp;
        System.out.println("Which temperature value do you want to convert it into?");
        System.out.println("Celsius(C) (or) Kelvin(K)");
        String temp1 = scanner.nextLine().toUpperCase();
        if(temp1.equals("C")){
            temp = (temperature - 32 ) * 5/9;
            System.out.printf("Hence the required temperature is: %.2f°C\n",temp);
        }
        else if(temp1.equals("K")){
            temp = ((temperature - 32) * 5/9) + 273.15;

                System.out.printf("Hence the required temperature is: %.2fK\n", temp);

        }
        else {
            System.out.println("Enter some valid input.");
            return false;
        }
        return true;
    }
}