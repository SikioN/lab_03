package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import places.DreamWorld;
import places.Place;
import types.CodeColor;
import types.ThinkingType;

import java.util.Random;

final public class Mumintroll extends Character implements Remember{
    public Mumintroll(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.BLUE + super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void jump(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }
    @Override
    public void watch(Character character) {
        if (this.equals(character)) {
            this.voiceLine(String.format("Как прекрасен %s", character.getName()));
        } else {
            this.voiceLine("Эхх... ничего не вижу...");
        }
    }

    @Override
    public void watch(Entity entity) {
        if (this.getLocation().getClass().equals(entity.getLocation().getClass()) && this.getLocation().getName().equals(entity.getLocation().getName())) {
            this.voiceLine(String.format("Как прекрасен %s", entity.getName()));
        } else {
            this.voiceLine("Эхх... ничего не вижу...");
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
        return String.format("Размышляет %s о %s.\n",  ThinkingType.values()[new Random().nextInt(ThinkingType.values().length)], about);
    }

    @Override
    public void remember() {
        if (Math.random() >= 0.5) {
            System.out.print(this.getName() + "\u001B[32m" + " отправился " + "\u001B[0m" + "в Мир воспоминаний, ");
            Place oldLocation = this.getLocation();

            this.setLocation(new DreamWorld("Мир воспоминаний"));

            class Snusmumriken extends Character {
                public Snusmumriken() {
                    super("Снусмумриком", new DreamWorld("Мир воспоминаний"));
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
            Snusmumriken sn = new Snusmumriken();

            if (this.equals(sn)) {
                System.out.printf("где встретился с %s! ", sn.getName());
            }

            System.out.printf("После чего вернулся в %s.\n", oldLocation.getName());
            this.setLocation(oldLocation);

        } else {
            System.out.print(this.getName() + "\u001B[31m" + " ничего " + "\u001B[0m" + "не вспомнил!\n");
        }

    }
}
