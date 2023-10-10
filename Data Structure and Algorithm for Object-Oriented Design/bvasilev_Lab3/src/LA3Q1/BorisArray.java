package LA3Q1;

public class BorisArray {
    private Pair<Integer, String>[] testArray;

    public BorisArray() {
        testArray = new Pair[0];
    }

    // Returns the current size of the array
    public int getSize() {
        return testArray.length;
    }

    // Removes the last element from the array
    public Pair<Integer, String> removeFromLastIndex() {
        Pair<Integer, String>[] tempArray = new Pair[testArray.length - 1];
        System.arraycopy(testArray, 0, tempArray, 0, testArray.length - 1);
        Pair<Integer, String> lastElem = testArray[testArray.length - 1];
        testArray = tempArray;
        return lastElem;
    }

    // Removes the first element from the array
    public Pair<Integer, String> removeFromFirstIndex() {
        Pair<Integer, String>[] tempArray = new Pair[testArray.length - 1];
        System.arraycopy(testArray, 1, tempArray, 0, testArray.length - 1);
        Pair<Integer, String> firstElem = testArray[0];
        testArray = tempArray;
        return firstElem;
    }

    // Returns a string representation of the current array
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (Pair<Integer, String> pair : testArray) {
            output.append(pair.toString());
        }
        output.append("]");
        return output.toString();
    }

    // Adds a Pair to the array
    public void addAtLastIndex(Pair<Integer, String> newPair) {
        Pair<Integer, String>[] tempArray = new Pair[testArray.length + 1];
        System.arraycopy(testArray, 0, tempArray, 0, testArray.length);
        tempArray[testArray.length] = newPair;
        testArray = tempArray;
    }
}
