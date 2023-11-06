package L4Q2;

public class Student implements Comparable<Student> {
    private Double score;
    private String firstName;
    private String lastName;

    /**
     * Creates a Student type variable with given values.
     * @param firstName the first name of the student.
     * @param lastName the last name of the student.
     * @param score the score of the student.
     */
    public Student(String firstName, String lastName, Double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    /**
     * Creates a Student type variable with default values.
     */
    public Student() {
        this.firstName = "Boris";
        this.lastName = "Vasilev";
        this.score = 99.99;
    }

    /**
     * Returns the score of the student
     * @return Double
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the score of the student.
     * @param score the score of the student.
     */
    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, score);
    }

    @Override
    public int compareTo(Student o) {
        return this.score.compareTo(o.score);
    }

    /**
     * Returns the last name of the student.
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     * @param firstName the first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the student.
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     * @param lastName the last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
