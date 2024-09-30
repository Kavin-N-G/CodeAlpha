import java.util.ArrayList;
import java.util.Scanner;
class Destination {
    private String location;
    private String startDate;
    private String endDate;
    private double estimatedBudget;
    public Destination(String location, String startDate, String endDate, double estimatedBudget) {
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimatedBudget = estimatedBudget;
    }
    public String getLocation() {
        return location;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public double getEstimatedBudget() {
        return estimatedBudget;
    }
    @Override
    public String toString() {
        return "Destination: " + location +
               "\nTravel Dates: " + startDate + " to " + endDate +
               "\nEstimated Budget: $" + String.format("%.2f", estimatedBudget) + "\n";
    }
}
public class TravelItineraryPlanner {
    private static final Scanner scanner = new Scanner(System.in);
    private ArrayList<Destination> itinerary = new ArrayList<>();

    private void addDestination() {
        System.out.println("\n=== Add New Destination ===");
        System.out.print("Enter destination name: ");
        String location = scanner.nextLine();
        System.out.print("Enter start date (e.g., 2024-12-01): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter end date (e.g., 2024-12-10): ");
        String endDate = scanner.nextLine();
        System.out.print("Enter estimated budget for this destination: $");
        double estimatedBudget = scanner.nextDouble();
        scanner.nextLine();
        Destination destination = new Destination(location, startDate, endDate, estimatedBudget);
        itinerary.add(destination);
        System.out.println("\nDestination added successfully!\n");
    }
    private void displayItinerary() {
        System.out.println("\n=== Your Travel Itinerary ===");
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added to the itinerary yet.\n");
        } else {
            for (int i = 0; i < itinerary.size(); i++) {
                System.out.println("Stop " + (i + 1) + ":");
                System.out.println(itinerary.get(i));
            }
        }
    }
    private void calculateTotalBudget() {
        if (itinerary.isEmpty()) {
            System.out.println("\nYour itinerary is empty. Add some destinations first.");
            return;
        }
        double totalBudget = 0;
        for (Destination destination : itinerary) {
            totalBudget += destination.getEstimatedBudget();
        }
        System.out.printf("\nTotal estimated budget for the entire trip: $%.2f\n", totalBudget);
    }
    private void displayMenu() {
        System.out.println("\n=== Travel Itinerary Planner Menu ===");
        System.out.println("1. Add a Destination");
        System.out.println("2. View Itinerary");
        System.out.println("3. Calculate Total Budget");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }
    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        int choice;
        System.out.println("=== Welcome to the Travel Itinerary Planner ===");
        do {
            planner.displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid numeric option.");
                scanner.next();
                planner.displayMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    planner.addDestination();
                    break;
                case 2:
                    planner.displayItinerary();
                    break;
                case 3:
                    planner.calculateTotalBudget();
                    break;
                case 4:
                    System.out.println("Exiting the Travel Itinerary Planner. Safe travels!");
                    break;
                default:
                    System.out.println("Error: Invalid option. Please choose between 1-4.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}
