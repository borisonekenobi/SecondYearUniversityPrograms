package LA5Q;

public class Plane {
    // Design choice: There is no need to add or delete Plane objects, therefore the array is the most efficient choice.
    private static final Plane[] planeModels = {
            new Plane('J', 68, new int[] {3, 7}, "Boeing 747-8"),
            new Plane('J', 55, new int[] {3, 7}, "Boeing 777-300ER"),
            new Plane('J', 44, new int[] {3, 7}, "Airbus A330-300"),
            new Plane('I', 45, new int[] {3, 6}, "Boeing 787-9"),
            new Plane('F', 37, new int[] {3}, "Airbus A321-200"),
            new Plane('F', 32, new int[] {3}, "Boeing 737 MAX 8"),
            new Plane('E', 32, new int[] {2}, "Bombardier CS300"),
            new Plane('B', 1, new int[] {1}, "Cessna 152")
    };

    private final char endLetter;
    private final int endRow;
    // Design choice: There is no need to add or delete integers, therefore the array is the most efficient choice.
    private final int[] cumulativeWalkwayPosition;
    private final String model;

    /**
     * Creates a Plane object
     * @param endLetter A character representing the last letter of seat on each row
     * @param endRow An integer representing the last row of seats of the plane
     * @param cumulativeWalkwayPosition An integer array representing the cumulative position of walkways of the plane
     * @param model A String representing the model of the plane
     */
    private Plane(char endLetter, int endRow, int[] cumulativeWalkwayPosition, String model) {
        this.endLetter = endLetter;
        this.endRow = endRow;
        this.cumulativeWalkwayPosition = cumulativeWalkwayPosition;
        this.model = model;
    }

    /**
     * Gets the number of rows of seats in a plane
     * @return An integer representing the number of rows
     */
    public int getRows() {
        return endRow;
    }

    /**
     * Gets the number of seats per row in a plane
     * @return An integer representing the number of seats
     */
    public int getLastLetter() {
        return endLetter;
    }

    /**
     * Gets the cumulative walkway positions
     * @return An integer array representing the cumulative position of walkways of the plane
     */
    public int[] getCumulativeWalkwayPosition() {
        return cumulativeWalkwayPosition;
    }

    @Override
    public String toString() {
        return model;
    }

    /**
     * Generates a random Plane with pre-set information
     * @return The generated Plane object
     */
    public static Plane generatePlane() {
        return planeModels[Main.getRandom().nextInt(planeModels.length)];
    }
}
