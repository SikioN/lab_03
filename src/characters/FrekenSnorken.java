package characters;

import places.Place;

public class FrekenSnorken extends Character implements Remember{
    public FrekenSnorken(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getRemember() {
        return null;
    }

    @Override
    public String remember() {
        return null;
    }
}
