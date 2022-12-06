package types;

import java.util.Random;

public enum ThinkingType {
    SILENTLY ("безмолвно"),
    ALARMINGLY ("тревожно"),
    CHEERFULLY ("радостно"),
    TIREDLY ("уставше");

    private final String title;
    private static final Random r;

    ThinkingType(String title) {
        this.title = title;
    }

    static {
        r = new Random();
    }

    public String getTitle() {
        return title;
    }

    private static ThinkingType randomStyle() {
        return ThinkingType.values()[r.nextInt(ThinkingType.values().length)];
    }

    @Override
    public String toString() {
        return this.title;
    }}
