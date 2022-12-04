package characters;

import java.util.Random;

public enum JumpStyle {
    SOFT ("мягко"),
    HEAVY ("тяжело"),
    CLUMSILY ("неуклюже"),
    TIRED ("уставше"),
    HIGHER ("высоко"),
    CAREFULLY ("осторожно");

    private String title;

    JumpStyle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private JumpStyle randomStyle() {
        int r = new Random().nextInt(JumpStyle.values().length);
        return JumpStyle.values()[r];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
