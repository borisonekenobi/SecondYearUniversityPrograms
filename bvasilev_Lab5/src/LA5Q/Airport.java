package LA5Q;

public class Airport {
    private static final Airport sourceAirport = new Airport("YYZ", "Toronto, Ontario", "Canada");
    // Design choice: There is no need to add or delete Airport objects, therefore the array is the most efficient
    // choice.
    private static final Airport[] airports = new Airport[] { new Airport("ATL", "Atlanta, Georgia", "United States"),
            new Airport("DFW", "Dallas-Fort Worth, Texas", "United States"), new Airport("DEN", "Denver, Colorado", "United States"),
            new Airport("ORD", "Chicago, Illinois", "United States"), new Airport("DXB", "Garhoud, Dubai", "United Arab Emirates"),
            new Airport("LAX", "Los Angeles, California", "United States"), new Airport("IST", "Arnavutköy, Istanbul", "Turkey"),
            new Airport("LHR", "Hillingdon, London", "United Kingdom"), new Airport("DEL", "Palam, Delhi", "India"),
            new Airport("CDG", "Roissy-en-France, Île-de-France", "France"), new Airport("JFK", "New York City, New York", "United States"),
            new Airport("LAS", "Las Vegas, Nevada", "United States"), new Airport("AMS", "Haarlemmermeer, North Holland", "Netherlands"),
            new Airport("MIA", "Miami-Dade County, Florida", "United States"), new Airport("MAD", "Madrid", "Spain"),
            new Airport("HND", "Ōta, Tokyo", "Japan"), new Airport("MCO", "Orlando, Florida", "United States"),
            new Airport("FRA", "Frankfurt, Hesse", "Germany"), new Airport("CLT", "Charlotte, North Carolina", "United States"),
            new Airport("MEX", "Venustiano Carranza, Mexico City", "Mexico"), new Airport("SEA", "SeaTac, Washington", "United States"),
            new Airport("PHX", "Phoenix, Arizona", "United States"), new Airport("EWR", "Newark, New Jersey", "United States"),
            new Airport("SFO", "San Mateo County, California", "United States"), new Airport("BCN", "Barcelona", "Spain"),
            new Airport("IAH", "Houston, Texas", "United States"), new Airport("CGK", "Tangerang, Banten", "Indonesia"),
            new Airport("BOM", "Santacruz-Sahar, Mumbai, Maharashtra", "India"), new Airport("BOS", "East Boston, Massachusetts", "United States"),
            new Airport("DOH", "Doha", "Qatar"), new Airport("BOG", "Bogotá", "Colombia"),
            new Airport("GRU", "Guarulhos", "Brazil"), new Airport("SGN", "Ho Chi Minh City", "Vietnam"),
            new Airport("LGW", "Crawley, West Sussex", "United Kingdom"), new Airport("SIN", "Changi, East Region", "Singapore"),
            new Airport("FLL", "Broward County, Florida", "United States"), new Airport("JED", "Jeddah", "Saudi Arabia"),
            new Airport("MUC", "Freising, Bavaria", "Germany"), new Airport("AYT", "Antalya", "Turkey"),
            new Airport("SAW", "Pendik, Istanbul", "Turkey"), new Airport("MSP", "St. Paul, Minnesota", "United States"),
            new Airport("CUN", "Cancún", "Mexico"), new Airport("MNL", "Pasay/Parañaque, Metro Manila", "Philippines"),
            new Airport("CJU", "Jeju City", "South Korea"), new Airport("FCO", "Fiumicino, Rome metro", "Italy"),
            new Airport("ORY", "Orly, Paris metro", "France"), new Airport("SYD", "Mascot, New South Wales", "Australia"),
            new Airport("LGA", "Queens, New York City", "United States"), new Airport("BKK", "Racha Thewa, Bangkok metro", "Thailand")
    };

    private final String code;
    private final String location;
    private final String country;

    /**
     * Creates an Airport object
     * @param code A String representing the 3-letter code of the airport
     * @param location A String representing the location of the airport
     * @param country A String representing the country the airport is in
     */
    public Airport(String code, String location, String country) {
        this.code = code;
        this.location = location;
        this.country = country;
    }

    @Override
    public String toString() {
        return shortFormat();
    }

    /**
     * Creates a String with the location of the airport shortened to 35 characters
     * @return A String representing the airport
     */
    public String shortFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cityChars = location.toCharArray();
        for (int i = 0; i < Math.min(35, cityChars.length); i++) {
            stringBuilder.append(cityChars[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * Creates a String with all information about the airport
     * @return A String representing the airport
     */
    public String longFormat() {
        return String.format("%s %s, %s", code, location, country);
    }

    /**
     * Gets the source airport
     * @return An Airport representing the airport that can be travelled from
     */
    public static Airport getSourceAirport() {
        return sourceAirport;
    }

    /**
     * Gets the array of destination airports
     * @return An Airport array representing the airports that can be travelled to
     */
    public static Airport[] getAirports() {
        return airports;
    }
}
