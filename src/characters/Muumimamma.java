package characters;

import places.Place;

public class Muumimamma extends Character implements Remember{
    public Muumimamma(String name, Place location) {
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
