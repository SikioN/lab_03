package characters;

import places.Place;

public class Mumintroll extends Character implements Remember{
    public Mumintroll(String name, Place location) {
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
