package entities;

import places.Place;
import places.Void;

import java.util.Objects;

public abstract class Entity {
    final private String name;
    private Place location = null;

    public Entity(String name) {
        this.name = Objects.requireNonNullElse(name, "Ничто");
    }

    public Entity(String name, Place location) {
        this.name = Objects.requireNonNullElse(name, "Ничто");
        this.location = Objects.requireNonNullElseGet(location, Void::new);
    }

    @Override
    public String toString() {
        if (location != null) {
            return String.format("%s в %s", this.name, this.location);
        }
        return String.format("%s", this.name);
    }
}
