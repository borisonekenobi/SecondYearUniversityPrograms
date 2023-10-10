package LA3Q1;

public class Pair<Y, N> {
    private Y key;
    private N value;

    public Pair(Y key, N value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(Y key) {
        this.key = key;
    }

    public void setvalue(N value) {
        this.value = value;
    }

    public Y getKey() {
        return key;
    }

    public N getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("[YR: %s, NM: %s]", key, value);
    }
}
