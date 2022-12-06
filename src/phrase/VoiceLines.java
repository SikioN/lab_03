package phrase;

import java.util.Random;

public enum VoiceLines {
    SILENTLY ("Хммм..."),
    RUBIN ("Нужно больше Рубинов!"),
    ENTHUSIASTICALLY ("Я – король! Король РУБИНОВ!"),
    ARROGANTLY ("Королями не становятся... Ими рождаются! Ха-ха-ха!");

    private final String title;

    VoiceLines(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static VoiceLines randomStyle() {
        int r = new Random().nextInt(VoiceLines.values().length);
        return VoiceLines.values()[r];
    }

    @Override
    public String toString() {
        return this.title;
    }
}
