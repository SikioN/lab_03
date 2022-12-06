package entities;

import places.Place;
import types.CodeColor;
import types.Color;

import java.util.Objects;
import java.util.Random;

final public class Fire extends Entity implements Specificity {
    private final Color specificity;
    private final String code;

    public Fire(String name, Place location) {
        super(name, location);
        int r = new Random().nextInt(Color.values().length);
        specificity = Color.values()[r];
        code = CodeColor.values()[r].getTitle();

    }


    public void flaredUp() {
        int rate = -1 + (int) (Math.random() * 3);
        String message = code + this.getSpecificity() + "\u001B[0m " + this.getName() + (rate > 0 ? " разгорался всё сильнее. " : " медленно потухал... ");
        System.out.print(message);
    }

    public String getSpecificity() {
        return specificity.getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fire fire)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getSpecificity(), fire.getSpecificity()) && Objects.equals(code, fire.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpecificity(), code);
    }
}
