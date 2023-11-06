package L4Q1;

public class MyStudent {
    String firstName;
    Double score;

    /**
     * Creates a MyStudent type variable with default values.
     */
    public MyStudent() {
        this.firstName = "Boris";
        this.score = 99.99;
    }

    /**
     * Creates a MyStudent type variable with given values.
     * @param firstName the first name of the student.
     * @param score the score of the student.
     */
    public MyStudent(String firstName, Double score) {
        this.firstName = firstName;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", firstName, score);
    }
}
