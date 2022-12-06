package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import places.DreamWorld;
import places.Place;
import types.CodeColor;
import types.ThinkingType;

import java.util.Random;

final public class FrekenSnorken extends Character implements Remember{
    public FrekenSnorken(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.GREEN + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void jump(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public void watch(Character character) {
        if (this.equals(character)) {
            this.voiceLine(String.format("Видно %s", character.getName()));
        } else {
            this.voiceLine("Не видно ничего.");
        }
    }

    @Override
    public void watch(Entity entity) {
        if (this.getLocation().getClass().equals(entity.getLocation().getClass()) && this.getLocation().getName().equals(entity.getLocation().getName())) {
            this.voiceLine(String.format("Видно %s", entity.getName()));
        } else {
            this.voiceLine("Не видно ничего.");
        }
    }


    @Override
    public void walk(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public String getRemember(String about) {
        if (about == null) {
            about = "небытие";
        }
        return String.format("Вспоминает %s %s.\n", ThinkingType.values()[new Random().nextInt(ThinkingType.values().length)], about);
    }

    @Override
    public void remember() {
        if (Math.random() >= 0.25) {
            System.out.print(this.getName() + "\u001B[32m" + " думала " + "\u001B[0m" + "о Деревянном королевстве, ");
            Place oldLocation = this.getLocation();

            this.setLocation(new DreamWorld("Деревянное королевство"));

            class WoodenQueen extends Character {
                public WoodenQueen() {
                    super("Деревянная королев", new DreamWorld("Деревянное королевство"));
                }

                @Override
                public void jump(Place newLocation) throws UnsupportedMethod {
                    throw new UnsupportedMethod();
                }

                @Override
                public void watch(Entity entity) throws UnsupportedMethod {
                    throw new UnsupportedMethod();
                }

                @Override
                public void watch(Character character) throws UnsupportedMethod {
                    throw new UnsupportedMethod();
                }

                @Override
                public void walk(Place newLocation) throws UnsupportedMethod {
                    throw new UnsupportedMethod();
                }
            }


            WoodenQueen sn = new WoodenQueen();

            if (this.equals(sn)) {
                System.out.printf("где вновь встретилась в битве с %s! ", sn.getName());
            }

            if (Math.random() >= 0.8) {
                System.out.print("Как прежде, " + "\u001B[32m" + "победив" + "\u001B[0m" + " вернулась в " + oldLocation.getName() + "!\n");
            } else {
                System.out.print("Но в этот раз " + "\u001B[31m" + "проиграла" + "\u001B[0m" + " и вернулась в " + oldLocation.getName() + "...\n");
            }

            this.setLocation(oldLocation);

        } else {
            System.out.print(this.getName() + "\u001B[31m" + " ничего " + "\u001B[0m" + "не вспомнила!\n");
        }

    }
}
