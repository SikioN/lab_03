package characters;

import places.Place;

import java.util.Random;

public class Panter extends Character {
    public Panter(String name, Place location) {
        super(name, location);
    }

    public void jump(Place new_location) {
        String message;
        if (new_location == null) {
            message = String.format(this.getName() + " не захотела прыгать и осталась в %s. ", this.getLocation());
        } else {
            message = String.format(this.getName() + " %s спрыгнула с %s и приземлилась в %s ", JumpStyle.values()[new Random().nextInt(JumpStyle.values().length)], this.getLocation(), new_location.getName());
            this.setLocation(new_location);
        }
        System.out.print(message);
    }

}
