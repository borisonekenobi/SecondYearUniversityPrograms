package LE7Q1;

public class BorisValueEntry {
    private Integer key;

    /**
     * Creates a BorisValueEntry object
     */
    public BorisValueEntry() {
        this.key = null;
    }

    /**
     * Creates a BorisValueEntry object with the given key
     * @param key Integer value representing the key
     */
    public BorisValueEntry(Integer key) {
        this.key = key;
    }

    /**
     * Sets the key
     * @param key Integer value representing the key
     */
    public void setKey(Integer key) {
        this.key = key;
    }

    /**
     * Gets the key
     * @return Integer value representing the key
     */
    public Integer getKey() {
        return key;
    }
}
