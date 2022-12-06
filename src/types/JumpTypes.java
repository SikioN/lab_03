package types;

import java.util.Random;

public enum JumpTypes {
    SOFT ("мягко"),
    HEAVY ("тяжело"),
    CLUMSILY ("неуклюже"),
    TIRED ("уставше"),
    HIGHER ("высоко"),
    CAREFULLY ("осторожно");

    private final String title;
    private static final Random r;

    JumpTypes(String title) {
        this.title = title;
    }

    static {
        r = new Random();
    }

    public String getTitle() {
        return title;
    }

    // статик
    private static JumpTypes randomStyle() {
        return JumpTypes.values()[r.nextInt(JumpTypes.values().length)];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
