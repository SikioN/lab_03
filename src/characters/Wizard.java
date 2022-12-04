package characters;

import places.Place;

public class Wizard extends Character {

    public Wizard(String name, Place location) {
        super(name, location);
    }

    public void walk(Place new_location) {
        String message;

        if (new_location == null) {
            message = String.format(this.getName() + " остался в %s... ", this.getLocation());
        } else {
            message = String.format(this.getName() + " взял путь из %s в %s! ", this.getLocation(), new_location.getName());
            this.setLocation(new_location);
        }

        System.out.print(message);
    }


}
