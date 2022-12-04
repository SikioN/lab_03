package characters;

import places.Place;
import places.Void;

import java.util.Objects;

public abstract class Character {
    final private String name;
    private Place location;

    public Character(String name, Place location) {

        this.name = Objects.requireNonNullElse(name, "Безымянный герой");
        this.location = Objects.requireNonNullElseGet(location, Void::new);

    }

    public String getName() {
        return name;
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%s из %s", name, location.getName());
    }

    @Override
    public boolean equals(Object obj) {
        Character other = (Character) obj;
        return location.equals(other.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
