package LA5Q;

import java.util.*;

public class Flight {
    private static long ticketNumber = Main.getRandom().nextLong(2_500_000_000_000L, 5_000_000_000_000L);

    private final Airport source;
    private final Airport destination;
    private final String flightDesignator;
    private final int flightNum;
    private String gateNum;
    private final Plane plane;
    // Design choice: The passenger list will be dynamically assembled, therefore the Interface List was the appropriate
    // choice.
    private final List<Passenger> passengers;

    private FlightState state;

    /**
     * Creates a Flight object
     * @param source An Airport representing the source of the flight
     * @param destination An Airport representing the destination of the flight
     * @param flightDesignator A String representing a 2-character designator of the flight
     * @param flightNum An integer representing the 1 to 4-digit number of the flight
     * @param gateNum A String representing the gate of the flight
     * @param plane A Plane representing a plane selected for the flight
     */
    public Flight(Airport source, Airport destination, String flightDesignator, int flightNum, String gateNum, Plane plane) {
        this.source = source;
        this.destination = destination;
        this.flightDesignator = flightDesignator;
        this.flightNum = flightNum;
        this.gateNum = gateNum;
        this.plane = plane;

        int numSeats = plane.getRows() * (plane.getLastLetter() - 'A' + 1);
        // Design choice: ArrayList offers a good balance performance and is a good choice for the list of passengers.
        // An alternative data structure would be the LinkedList which would give us a better performance when adding an
        // element, O(1). On the other hand, by pre-allocating the capacity for the ArrayList, we're also gaining an
        // O(1) performance.
        passengers = new ArrayList<>(numSeats);
        for (int row = 1; row <= plane.getRows(); row++) {
            for (char seat = 'A'; seat <= plane.getLastLetter(); seat++) {
                // Leaving some seats unoccupied ~2%
                if (Main.getRandom().nextDouble() <= 0.02) continue;
                passengers.add(Passenger.generatePassenger(row, seat, getTicketNumber()));
            }
        }
        this.state = FlightState.readyToBeBoarded;
    }

    /**
     * Gets the flight number
     * @return A String representing the flight number
     */
    public String getFlightNum() {
        return String.format("%s %d", flightDesignator, flightNum);
    }

    /**
     * Gets the flight state
     * @return A FlightState representing the current state of the flight
     */
    public FlightState getState() {
        return state;
    }

    @Override
    public String toString() {
        String currentState;
        switch (state) {
            case readyToBeBoarded -> currentState = "Ready to Board";
            case readyToDepart -> currentState = "Ready to Depart";
            case inFlight -> currentState = "In Flight";
            case readyToBeDisembarked -> currentState = "At Destination";
            default -> currentState = "something went wrong..";
        }
        return String.format("%s %4d  %-35s  %-4s  %-16s  %s", flightDesignator, flightNum, destination, gateNum, plane, currentState);
    }

    /**
     * Prepares flight for take-off
     */
    public void board() {
        int seatsPerRow = plane.getLastLetter() - 'A' + 1;
        // Keeping seat schema in 2-dimensional array. Design choice: since we know the size of the 2-dimensional array,
        // we can choose the simplest data structure, an array. Lists will be slower and are not optimal for memory.
        boolean[][] seatsStatus = new boolean[plane.getRows()][seatsPerRow];
        for (Passenger passenger : passengers) {
            int seatRow = passenger.getSeatRow() - 1;
            char seatLtr = passenger.getSeatLtr();
            int seatLtrIndex = seatLtr - 'A';
            // Mark the seat as occupied
            seatsStatus[seatRow][seatLtrIndex] = true;

            passenger.board();
        }
        this.state = FlightState.readyToDepart;

        printSeatChart(seatsStatus);
    }

    /**
     * Plane takes off
     */
    public void takeOff() {
        this.state = FlightState.inFlight;
        this.gateNum = null;
    }

    /**
     * Plane lands
     */
    public void land() {
        this.state = FlightState.readyToBeDisembarked;
        this.gateNum = generateGate();
    }

    /**
     * Disembarks passengers from plane
     */
    public void disembark() {
        int seatsPerRow = plane.getLastLetter() - 'A' + 1;
        // Keeping seat schema in 2-dimensional array. Design choice: since we know the size of the 2-dimensional array,
        // we can choose the simplest data structure, an array. Lists will be slower and are not optimal for memory.
        Passenger[][] passengerSeats = new Passenger[plane.getRows()][seatsPerRow];
        for (Passenger passenger : passengers) {
            int seatRow = passenger.getSeatRow() - 1;
            char seatLtr = passenger.getSeatLtr();
            int seatLtrIndex = seatLtr - 'A';
            // Put current passenger in seat seatRow, seatLtrIndex
            passengerSeats[seatRow][seatLtrIndex] = passenger;
        }

        // Line-up passengers in a linear queue to exit the plane. Design choice: since the passengers need to exit in
        // a linear fashion, the Queue is an appropriate choice to order the passenger list. The simplest concrete class
        // that implements the Queue Interface, is the LinkedList.
        Queue<Passenger> disembarkQueue = new LinkedList<>();
        for (Passenger[] passengerSeat : passengerSeats) {
            Passenger[] scrambledRow = scramble(passengerSeat);
            disembarkQueue.addAll(Arrays.asList(scrambledRow));
        }

        System.out.println("Disembarking passengers, say bye as they pass by!");
        System.out.printf("%-30s  %-3s %s\n", "Passenger Name", "Seat", "Ticket Number");
        // Printing passengers' name, seat and ticket number as they disembark
        while (!disembarkQueue.isEmpty()) {
            Passenger p = disembarkQueue.remove();
            if (p == null) continue;
            p.disembark();
            System.out.println(p);
        }
        System.out.println(Colors.ANSI_GREEN + "All passengers have safely arrived at their destination!" + Colors.ANSI_RESET);
    }

    /**
     * Scrambles the given row of passengers
     * @param rowPassengers A Passenger array representing the row of passengers to be scrambled
     * @return The scrambled Passenger array
     */
    private Passenger[] scramble(Passenger[] rowPassengers) {
        for (int i = rowPassengers.length - 1; i > 0; i--) {
            int swapIndex = Main.getRandom().nextInt(0, i);
            Passenger temp = rowPassengers[i];
            rowPassengers[i] = rowPassengers[swapIndex];
            rowPassengers[swapIndex] = temp;
        }
        return rowPassengers;
    }

    /**
     * Generates a flight with random flight number, gate and plane
     * @return The generated Flight object
     */
    public static Flight generateFlight() {
        return new Flight(
                Airport.getSourceAirport(),
                Airport.getAirports()[Main.getRandom().nextInt(Airport.getAirports().length)],
                "CA", Main.getRandom().nextInt(9999),
                generateGate(),
                Plane.generatePlane()
        );
    }

    /**
     * Generates a gate with random gate letter and number
     * @return The generated gate number in String format
     */
    private static String generateGate() {
        return String.format("%c%d", Main.getRandom().nextInt('A', 'G'), Main.getRandom().nextInt(100));
    }

    /**
     * Prints the seating chart to the standard output of the program
     * @param seatsStatus A 2-dimensional boolean array representing the status of the seats on the airplane
     */
    public void printSeatChart(boolean[][] seatsStatus) {
        System.out.println("Seat chart for " + plane + ":");
        int[] cumulativeWalkwaysPosition = plane.getCumulativeWalkwayPosition();
        for (int i = 0; i < seatsStatus[0].length; i++) {
            // Check if current row is next to "walk-way" and print an empty line
            for (int k : cumulativeWalkwaysPosition) {
                if (k == i) System.out.println();
            }

            // Print a full column of seats (i.e. print all seats with given letter)
            for (boolean[] row : seatsStatus) {
                if (row[i]) System.out.print(Colors.ANSI_GREEN + "▢" + Colors.ANSI_RESET);
                else System.out.print("▣");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(Colors.ANSI_GREEN + "▢" + Colors.ANSI_RESET + " = seat filled");
        System.out.println("▣ = empty seat");
        System.out.println(Colors.ANSI_RED + "▢" + Colors.ANSI_RESET + " = problem!");
        System.out.println();
    }

    /**
     * Generates a ticket number
     * @return The generated long
     */
    public static long getTicketNumber() {
        return ++ticketNumber;
    }
}
