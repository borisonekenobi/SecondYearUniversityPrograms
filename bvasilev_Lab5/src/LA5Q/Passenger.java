package LA5Q;

public class Passenger {
    private static final String[] firstNames = {"Olga", "Valerie", "Victoria", "Keith", "Francis", "Bobbie", "Janie", "Frances", "Joey", "Krystal", "Ruben", "Kristy", "Salvador", "Luther", "Matt", "Johnnie", "Geoffrey", "Vickie", "Dixie", "Emma", "Tiffany", "Nadine", "Garrett", "Dave", "Gwendolyn", "Ginger", "Catherine", "Andy", "Judith", "Mindy", "Minnie", "Rudolph", "Dwayne", "Mercedes", "Alexander", "Neal", "Tom", "Whitney", "Roosevelt", "Jamie", "Doug", "Grace", "Cary", "Wade", "Beth", "Floyd", "Marc", "Dianna", "Angel", "Ed", "Jaime", "Ismael", "Krista", "Troy", "Diane", "Leticia", "Sue", "Faye", "Joel", "Alvin", "Lois", "Stella", "Roberta", "Shelly", "Javier", "Jeffery", "Priscilla", "Carolyn", "Crystal", "Elvira", "Leroy", "Ken", "Ruby", "Freda", "Lynda", "Michael", "Bryant", "Dean", "Katrina", "Debbie", "Erma", "Franklin", "Tracy", "Emmett", "Lydia", "Shannon", "Lynne", "Edgar", "Opal", "Patricia", "Myrtle", "Saul", "Theodore", "Camille", "Richard", "David", "Genevieve", "Lewis", "Tina", "Kevin", "Dwayne", "Beverly", "Sergio", "Brendan", "Juanita", "Celia", "Jennifer", "Phillip", "Kelvin", "Madeline", "Ann", "Pete", "Ana", "Wilson", "Michelle", "Erma", "Tomas", "Donnie", "Sue", "Nora", "Leigh", "Carroll", "Lorenzo", "Amos", "Herman", "Kimberly", "Miranda", "Kristopher", "Moses", "Mable", "Tonya", "Wesley", "Rosalie", "Charlene", "Armando", "Robert", "Blake", "Judy", "Maggie", "Katherine", "Wilma", "Charlotte", "Arturo", "Jonathan", "Oscar", "Earnest", "Merle", "Melissa", "Lola", "Randolph", "Miriam", "Donna", "Glenn", "Pearl", "Craig", "May", "Winifred", "Philip", "Ricky", "Angelo", "Wilfred", "Luz", "Ira", "Gerald", "Lynda", "Sheri", "Aubrey", "Carlton", "Allison", "Guy", "Sherri", "Carlos", "Caroline", "Jeffery", "Conrad", "Ida", "Franklin", "Dianna", "Alison", "Richard", "Lucy", "Terry", "Danielle", "Shari", "Allan", "Troy", "Daisy", "Lewis", "Otis", "Leslie", "Joan", "Cary", "Ron", "Alberto", "Ramon", "Nina", "Duane", "Jessie", "Jermaine", "Gloria", "Sherri", "Nicholas", "June", "Debbie", "Tina", "Betty", "April", "Dixie", "Archie", "Tim", "Patsy", "Sonja", "Ashley", "Craig", "Renee", "Willie", "Rex", "Faith", "Felicia", "Penny", "William", "Sylvester", "Michael", "Steven", "Valerie", "Clifford", "Miranda", "Brett", "Bennie", "Felix", "Ramona", "Sophia", "Misty", "Marie", "Leslie", "Bill", "Darlene", "Emily", "Roger", "Rachel", "Dallas", "James", "Mabel", "Malcolm", "Flora", "David", "Hazel", "Juan", "Henrietta", "Greg", "Adrienne", "Eugene", "Alvin", "Carrie", "Daisy", "Blake", "Ron", "Bobby", "Woodrow", "Tom", "Mario", "Moses", "Byron", "Fernando", "Elsa", "Celia", "Julie", "Danielle", "Jan", "Jonathon", "Terri", "Wilbert", "Casey", "Rosa", "Jeremiah", "Teresa", "Jackie", "Betsy", "Sue", "Elvira", "Camille", "Mary", "Tracy", "Lionel", "Belinda", "Diana", "Marvin", "Boyd", "Gregg", "Eunice", "Ismael", "Alexandra", "Wilson", "Pablo", "Angela", "Troy", "Chris", "Derrick", "Johnathan", "Carol"};
    private static final String[] lastNames = {"Rhodes", "Wilson", "Stokes", "Ferguson", "Haynes", "Stone", "Aguilar", "Norman", "Reed", "Graham", "Murray", "Rodriquez", "Chambers", "Wong", "Morgan", "Morris", "Flowers", "Schwartz", "Patterson", "Allison", "Bailey", "Gomez", "Mathis", "Alvarez", "Holt", "Parks", "Phelps", "Kelley", "Morrison", "Rivera", "Kennedy", "Adams", "Scott", "Moss", "Sims", "Ramirez", "Bowers", "Erickson", "Watts", "Gray", "Kim", "Norris", "Patrick", "Larson", "Carroll", "Fitzgerald", "Simpson", "Hopkins", "Martin", "Moreno", "Colon", "Bass", "Christensen", "Quinn", "Wilkins", "Ruiz", "Neal", "Jones", "Collins", "Jimenez", "Dixon", "Saunders", "Yates", "Holmes", "James", "Bradley", "Gilbert", "Jennings", "Jacobs", "Evans", "Walton", "Delgado", "Hansen", "Garza", "Harrington", "Joseph", "Welch", "Steele", "Dean", "Strickland", "Cooper", "Mckinney", "Blake", "Hammond", "Lindsey", "Harvey", "Ryan", "Ingram", "Robertson", "Davis", "Nunez", "Daniel", "Dunn", "Owens", "Brewer", "Thomas", "Lambert", "Mcdonald", "Hart", "Dawson", "Cruz", "Ellis", "Knight", "Fuller", "Guzman", "Fletcher", "Paul", "Bishop", "Riley", "Mccoy", "Hanson", "Wilkerson", "Russell", "Meyer", "Vargas", "Vega", "Hampton", "Maldonado", "Lindsey", "Gill", "Montgomery", "Williams", "Mckinney", "Howell", "Hughes", "Collins", "Hall", "Jefferson", "Stewart", "Kelly", "Roy", "Parker", "Morales", "Murphy", "Hammond", "Cain", "Lewis", "Figueroa", "Goodwin", "Marsh", "Park", "Warren", "Pena", "Barnett", "Stevenson", "Mcdonald", "Barnes", "Huff", "Lopez", "Gonzalez", "Cole", "Roberts", "Becker", "Harrison", "Burton", "Osborne", "Horton", "Graves", "Gonzales", "Richardson", "Cook", "Schmidt", "Barber", "Maxwell", "Bryant", "Bowers", "Pittman", "Quinn", "Beck", "Stanley", "Hayes", "Chandler", "Sanders", "Lucas", "Peters", "Hoffman", "Cross", "Peterson", "Greer", "Tate", "Foster", "Erickson", "Blair", "Carr", "Herrera", "Webster", "Ryan", "Griffith", "Wheeler", "Powell", "Sanchez", "Burgess", "Reid", "Nash", "Alvarez", "Wood", "Grant", "Patterson", "Zimmerman", "Floyd", "Tran", "Duncan", "Fuller", "Wilson", "Santiago", "Armstrong", "Bowman", "Kelley", "Abbott", "Jenkins", "Dean", "Torres", "Valdez", "Townsend", "Holloway", "Ramos", "Briggs", "Ruiz", "Swanson", "Glover", "Alexander", "Chapman", "Hayes", "Wilkerson", "Reynolds", "Hogan", "Steele", "Davidson", "Bryant", "Russell", "Flowers", "Gibbs", "Morrison", "George", "Webster", "Hicks", "Baldwin", "Garner", "Cunningham", "Sandoval", "Brooks", "Hodges", "Parks", "Holmes", "Perry", "Morales", "Cohen", "Larson", "Gonzales", "Franklin", "Buchanan", "Strickland", "Collins", "Patrick", "Todd", "Newton", "Vasquez", "Webb", "Mclaughlin", "Chambers", "Stokes", "Tyler", "Cook", "Myers", "Alvarez", "Ortiz", "Morris", "Bell", "Owens", "Ortega", "Jacobs", "Hudson", "Burgess", "Cooper", "Cortez", "Joseph", "Warren", "Pierce", "Rhodes", "Weber", "Lee", "Romero", "Ferguson", "Hale", "Payne", "Greene", "Boone", "Wallace", "Silva", "Ray", "Willis", "Munoz", "Edwards", "Griffin", "Olson", "Jordan", "Wheeler", "Sharp", "Malone", "Byrd"};

    private final String firstName;
    private final String lastName;
    private final int seatRow;
    private final char seatLtr;
    private final long ticketNum;
    private PassengerState state;

    /**
     * Creates a Passenger object
     * @param firstName A String representing the first name of the passenger
     * @param lastName A String representing the last name of the passenger
     * @param seatRow An integer representing the seat row of the passenger
     * @param seatLtr A character representing the seat letter of the passenger
     * @param ticketNum A long integer representing the ticket number of the passenger
     */
    public Passenger(String firstName, String lastName, int seatRow, char seatLtr, long ticketNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.seatRow = seatRow;
        this.seatLtr = seatLtr;
        this.ticketNum = ticketNum;
        this.state = PassengerState.CheckedIn;
    }

    /**
     * Gets the passenger's seat number
     * @return A String representing a seat number
     */
    public String getSeatNum() {
        return String.format("%d%c", seatRow, seatLtr);
    }

    /**
     * Gets the passenger's seat row
     * @return An integer representing a seat row
     */
    public int getSeatRow() {
        return seatRow;
    }

    /**
     * Gets the passenger's seat letter
     * @return A character representing a seat letter
     */
    public char getSeatLtr() {
        return seatLtr;
    }

    @Override
    public String toString() {
        return String.format("%-30s  %-3s  %s", getName(), getSeatNum(), ticketNum);
    }

    /**
     * Generates a passenger with a random first and last name
     * @param seatRow An integer representing a seat row
     * @param seatLtr A character representing a seat letter
     * @param ticketNum A String representing a ticket number
     * @return The generated passenger object
     */
    public static Passenger generatePassenger(int seatRow, char seatLtr, long ticketNum) {
        return new Passenger(
                firstNames[Main.getRandom().nextInt(firstNames.length)],
                lastNames[Main.getRandom().nextInt(lastNames.length)],
                seatRow,
                seatLtr,
                ticketNum
        );
    }

    /**
     * Will board the passenger onto the plane
     * @throws IllegalStateException Throws error if passenger is in the incorrect state to board the plane
     */
    public void board() {
        if (state == PassengerState.CheckedIn) {
            state = PassengerState.Boarded;
        } else {
            throw new IllegalStateException("The passenger is in the wrong state, and cannot board the plane!");
        }
    }

    /**
     * Will disembark the passenger off the plane
     * @throws IllegalStateException Throws error if passenger is in the incorrect state to disembark the plane
     */
    public void disembark() {
        if (state == PassengerState.Boarded) {
            state = PassengerState.Disembarked;
        } else {
            throw new IllegalStateException("The passenger is in the wrong state, and cannot disembark the plane!");
        }
    }

    /**
     * Gets the full name of the passenger
     * @return A String representing a passenger's full name
     */
    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
}
