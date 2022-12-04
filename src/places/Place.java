package places;

import java.util.Objects;

public abstract class Place {
    final private String name;
    private String location = null;

    public Place(String name) {

        this.name = Objects.requireNonNullElse(name, "Безымянное место");

    }

    public Place(String name, Place location) {
        this.name = Objects.requireNonNullElse(name, "Безымянное место");

        if (location == null) {
            Place p = new Place("Долина пустоты") {
                @Override
                public String getName() {
                    return super.getName();
                }
            };
            this.location = p.getName();
        }
        else {
            this.location = location.getName();
        }

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (location != null) {
            return String.format("%s в %s", name, location);
        }
        return String.format("%s", name);
    }

}
