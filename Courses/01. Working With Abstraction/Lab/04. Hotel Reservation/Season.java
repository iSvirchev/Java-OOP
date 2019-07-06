public enum Season {
    AUTUMN(1),
    SUMMER(4),
    SPRING(2),
    WINTER(3);

    private int value;
    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
