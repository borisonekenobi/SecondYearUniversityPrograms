package LE6Q2;

public class StudentGrade implements Comparable<StudentGrade> {
    private String firstName;
    private String lastName;
    private int grade;

    /**
     * Creates a StudentGrade object
     */
    public StudentGrade() {

    }

    /**
     * Creates a StudentGrade object
     *
     * @param firstName The first name of the student
     * @param lastName  The last name of the student
     * @param grade     The grade of the student
     */
    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    /**
     * Gets the last name of the student
     *
     * @return String representing the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student
     *
     * @param lastName String which the last name will be set to
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the student
     *
     * @return String representing the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student
     *
     * @param firstName String which the first name will be set to
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the grade of the student
     *
     * @return int representing the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the student
     *
     * @param grade int which the grade will be set to
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(StudentGrade o) {
        return this.grade - o.getGrade();
    }

    @Override
    public String toString() {
        String fullName = String.format("%s %s", firstName, lastName);
        return String.format("%17s : \t%d", fullName, grade);
    }
}
