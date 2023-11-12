/**
 * Requirements:
 * The application will offer 2 modes, a tutorial and game
 *  - Tutorial: walks the user through the processing of a single flight
 *  - Game: offers the user the full functionality of the game
 * The application will generate random flights.
 * Each flight will have a random list of passengers
 *  - Specifications
 *     - The list of passengers should mimic the count of passengers in a real plane
 *     - The passengers should have realistic names
 *     - The generated ticket numbers should have 13 digits
 *     - Every ticket number should also be unique
 * The application will maintain a list of flights.
 *  - Specifications
 *     - Every flight destination should be to a well-known airport
 *     - The application should be able to maintain 50 airports
 *     - One of these, should always be the source airport (to mimic flights leaving from an airport)
 * Each flight will have one of the following states:
 * 	- Ready to be boarded
 * 	- Ready to depart
 * 	- In Flight
 * 	- Ready to be disembarked
 * 	- Specifications
 * 	   - The states should follow this order:
 * 	      - Ready to be boarded -> ready to depart -> in flight -> ready to be disembarked
 * The application will allow the user to select a flight.
 *  - Specifications
 *     - The selection will be made by entering a flight number
 *     - The user should be able to enter any number of spaces between the flight designator and flight number
 * Each passenger will have the following states:
 *   - Checked-in
 *   - Boarded
 *   - Disembarked
 *   - Specifications
 * 	    - The states should follow this order:
 *         - Checked-in -> boarded -> disembarked
 * Once a flight is selected for boarding, the application will:
 *  - board all passengers onto the plane
 *  - print a seating chart
 *  - Specifications
 *     - The seating chart should resemble a real seating chart with aisles in-between
 *     - Every occupied seat should be printed in green
 *     - Every unoccupied seat should be printed in white
 *     - A legend should also be printed to help the user understand
 * Once a flight is selected for disembarking, the application will:
 *  - print a queue of all disembarked passengers starting from the front row and going through all rows consecutively
 *  - the passengers from a particular row will disembark in a random order
 *  - Specifications
 *     - For every passenger, their name, seat and ticket number will be printed
 * 🙂
 */

package LA5Q;

import java.util.*;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Random random = new Random(System.currentTimeMillis());
    private static int flightCounter;

    /**
     * The starting point of the program
     * @param args Arguments passed to the program (will be unused)
     */
    public static void main(String[] args) {
        myHeader(5, 1);

        while (true) {
            System.out.println("Welcome to the Airplane Boarding and Disembarking application!");
            System.out.println(Colors.ANSI_YELLOW + "* WARNING: No game data will be saved on hard disk *" + Colors.ANSI_RESET);
            System.out.println("Please select one of the following options to play:");
            System.out.println("\t0. Tutorial");
            System.out.println("\t1. Game");
            int choice = -1;
            do {
                System.out.print("Enter the number corresponding to your choice: ");
                try {
                    choice = Integer.parseInt(input.nextLine());
                } catch (Exception e) {
                    System.out.println(Colors.ANSI_RED + "Invalid Choice!" + Colors.ANSI_RESET);
                }
            } while (choice < 0);

            switch (choice) {
                case 0 -> { tutorial(); continue; }
                case 1 -> game();
            }

            String playAgain;
            do {
                System.out.print("Would you like to play again? ");
                playAgain = input.nextLine();
                if (playAgain.startsWith("n")) {
                    myFooter(5, 1);
                    return;
                }
                if (!(playAgain.startsWith("y") || playAgain.startsWith("n"))) System.out.println(Colors.ANSI_RED + "Invalid Choice!" + Colors.ANSI_RESET);
            } while (!playAgain.startsWith("y"));
        }
    }

    /**
     * Used at the beginning of the code to show who wrote the code and the goal of the exercise.
     * @param labE_number Lab Exercise number
     * @param q_number Question number
     */
    public static void myHeader(int labE_number, int q_number) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q%d
                Prepared By: %s %s
                Student Number: 251276924
                Goal of this Exercise: To show my understanding of the usage of linear data structures
                =======================================================
                """, labE_number, q_number, "Boris", "Vasilev");
    }

    /**
     * Used at the end of the code to signify a successful completion.
     * @param labE_number Lab Exercise number
     * @param q_number Question number
     */
    public static void myFooter(int labE_number, int q_number) {
        System.out.printf("""
                =======================================================
                Completion of Lab Exercise %d-Q%d is successful!
                Signing off - Boris
                =======================================================
                """, labE_number, q_number);
    }

    /**
     * The tutorial for the game
     */
    private static void tutorial() {
        System.out.println("Welcome to the Tutorial!\n");
        // Design choice: Even though I'm adding only a single flight to the ArrayList, the program later deletes this
        // Flight object. Hence, this needs to be a dynamic collection and my code is simplified by it not being an
        // array.
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(Flight.generateFlight());

        gameLoop(flights);
    }

    /**
     * The main gameplay method
     */
    private static void game() {
        System.out.println("Welcome to the Game!\n");
        // Design choice: The program later adds/deletes Flight objects from this list. Hence, this needs to be a
        // dynamic collection and my code is simplified by it not being an array.
        ArrayList<Flight> flights = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            flights.add(Flight.generateFlight());
        }

        gameLoop(flights);
    }

    /**
     * The loop of the game
     * @param flights A List of Flight objects representing the starting flights. Design choice: the method will work
     *                with any List, hence the parameter type is of type Interface List.
     */
    private static void gameLoop(List<Flight> flights) {
        while (true) {
            printFlights(flights);

            Flight flight = chooseFlight(flights);
            if (flight == null) {
                System.out.print("Would you like to go back to the main menu? ");
                String exiting = input.nextLine();
                if (exiting.startsWith("y")) return;
                else continue;
            }

            System.out.println(flight);

            if (!boardFlight(flight)) continue;

            // Simulating the flight taking off and landing so that the flight is ready to be disembarked
            if (flight.getState() == FlightState.readyToDepart) flight.takeOff();
            if (flight.getState() == FlightState.inFlight) flight.land();

            if (flight.getState() == FlightState.readyToBeDisembarked) {
                System.out.println();
                if (!disembarkFlight(flights, flight)) continue;
                // If this is executed in tutorial mode, the user has the
                // option to generate a new flight and extend the tutorial
                generateTutorialFlight(flights);
                if (flights.isEmpty()) return;
            }
        }
    }

    /**
     * User selects a flight to process
     * @param flights A collection of available Flight objects. Design choice: the logic always iterates through the
     *                full Iterable. Hence, the Iterable Interface is an appropriate choice.
     * @return A Flight object corresponding to the user's selection
     */
    private static Flight chooseFlight(Iterable<Flight> flights) {
        Flight flight = null;
        while (true) {
            System.out.print("Please enter the flight number of the flight you wish to process, or nothing to exit: ");
            String flightNum = input.nextLine();
            if (flightNum.isEmpty()) break;

            if (flightNum.startsWith("CA")) {
                flightNum = String.join(" ", "CA", flightNum.substring(2).trim());
            }

            for (Flight f : flights) {
                if (f.getFlightNum().equals(flightNum)) flight = f;
            }
            if (flight != null) break;
            System.out.println(Colors.ANSI_RED + "Invalid Choice!" + Colors.ANSI_RESET);
        }
        return flight;
    }

    /**
     * Boards the given flight if possible
     * @param flight The flight to be boarded
     * @return false if user chose not to board the flight, true if otherwise
     */
    private static boolean boardFlight(Flight flight) {
        String shouldBoard;
        if (flight.getState() == FlightState.readyToBeBoarded)  {
            while (true) {
                System.out.println();
                System.out.print("This flight is ready to be boarded. Proceed? ");
                shouldBoard = input.nextLine().toLowerCase();
                if (shouldBoard.startsWith("y") || shouldBoard.startsWith("n")) break;
                System.out.println(Colors.ANSI_RED + "Invalid Choice!" + Colors.ANSI_RESET);
            }
            if (shouldBoard.startsWith("y")) flight.board();
            else return false;
            System.out.println(flight);
        }
        return true;
    }

    /**
     * Disembarks the given flight
     * @param flights A List of Flight objects which this flight will be deleted from after disembarking. Design choice:
     *                the method will work with any List, hence the parameter type is of type Interface List.
     * @param flight The flight to be disembarked
     * @return true if disembarked, false otherwise
     */
    private static boolean disembarkFlight(List<Flight> flights, Flight flight) {
        String shouldDisembark;
        while (true) {
            System.out.print("This flight is ready to be disembarked. Proceed? ");
            shouldDisembark = input.nextLine().toLowerCase();
            if (shouldDisembark.startsWith("y") || shouldDisembark.startsWith("n")) break;
            System.out.println(Colors.ANSI_RED + "Invalid Choice!" + Colors.ANSI_RESET);
        }

        if (shouldDisembark.startsWith("y")) {
            flight.disembark();
            // Once the flight is disembarked, it can be removed from the schedule
            flights.remove(flight);
            // Increase the count of flights that the user successfully processed
            flightCounter++;
            return true;
        }
        return false;
    }

    /**
     * Extends the tutorial if user chooses to do so
     * @param flights A List of available flights. Design choice: the method will work with any List, hence the
     *                parameter type is of type Interface List.
     */
    private static void generateTutorialFlight(List<Flight> flights) {
        if (flights.isEmpty()) {
            String playAgain;
            do {
                System.out.print("Would you like to play the tutorial again? ");
                playAgain = input.nextLine();
                if (playAgain.startsWith("n")) return;
                if (!playAgain.startsWith("y")) System.out.println(Colors.ANSI_RED + "Invalid Choice!" + Colors.ANSI_RESET);
            } while (!playAgain.startsWith("y"));
        }

        flights.add(Flight.generateFlight());
    }

    /**
     * Will print all the flights in an orderly fashion
     * @param flights An ArrayList representing the list of flights to be printed. Design choice: the logic always
     *                iterates through the full Iterable. Hence, the Iterable Interface is an appropriate choice.
     */
    private static void printFlights(Iterable<Flight> flights) {
        System.out.println();
        System.out.println(Colors.ANSI_GREEN + "Completed flights: " + flightCounter + Colors.ANSI_RESET);
        System.out.printf("%-7s  %-35s  %s  %-16s  %s\n", "Flight", "Destination", "Gate", "Plane", "State");

        for (Flight f : flights) {
            System.out.println(f);
        }

        System.out.println();
    }

    /**
     * Gets the random object for the program
     * @return Random object
     */
    public static Random getRandom() {
        return random;
    }
}
