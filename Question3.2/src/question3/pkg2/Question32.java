package question3.pkg2;
import java.util.LinkedList;
import java.util.Scanner;

public class Question32 {
    
    // A function to print the required route
    public static String plotRoute(String departure, String destination, LinkedList<String> stops) {
        // return an error if the entered departure point does not exist
        if (!stops.contains(departure)) {
            return "Departure point not found";
        }
        // return an error if the entered destination does not exist
        if (!stops.contains(destination)) {
            return "Destination not found";
        }
        
        // the index of the departure point
        int depIndex = stops.indexOf(departure);
        // the index of the destination
        int desIndex = stops.indexOf(destination);
        
        // string to store the output
        String route = "Traveling from " + departure + " to " + destination + ":\n";
        // if the index of the departure is less than the index of the destination, loop forward in the linked list
        if (depIndex < desIndex) {
            int i = depIndex;
            while (i < desIndex) {
                route += "Currently at: " + stops.get(i) + "\n";
                route += "Next Stop: " + stops.get(i + 1) + "\n";
                i++;
            }
            route += "Currently at: " + stops.get(i) + "\n";
            route += "Final stop reached.\n";
            route += "Destination reached: " + destination + "\n";
        }
        // if the index of the departure is greater than the index of the destination, loop in reverse
        if (depIndex > desIndex) {
            int i = depIndex;
            while (i > desIndex) {
                route += "Currently at: " + stops.get(i) + "\n";
                route += "Next Stop: " + stops.get(i - 1) + "\n";
                i--;
            }
            route += "Currently at: " + stops.get(i) + "\n";
            route += "Final stop reached.\n";
            route += "Destination reached: " + destination + "\n";
        }
        
        return route;
    }
    
    public static void main(String[] args) {
        // Instantiating and populating the linked list
        LinkedList<String> route = new LinkedList<>();
        route.add("Johannesburg CBD");
        route.add("Park Station");
        route.add("Midrand");
        route.add("Centurion");
        route.add("Pretoria CBD");
        
        // Instantiating Scanner object and asking user for the deperture point and destination
        Scanner input = new Scanner(System.in);
        System.out.print("Enter departure point: ");
        String departure = input.nextLine();
        System.out.print("Enter destination: ");
        String destination = input.nextLine();
        
        // Printing the result of the called function
        System.out.print(plotRoute(departure, destination, route));
    }
    
}
