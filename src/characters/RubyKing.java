package characters;

import entities.Entity;
import myexception.UnsupportedMethod;
import phrase.VoiceLines;
import places.Place;
import types.CodeColor;

import java.util.Random;

final public class RubyKing extends Character {
    public RubyKing(String name, Place location) {
        super(name, location);
    }

    @Override
    public String getName() {
        return CodeColor.RED +super.getName() + CodeColor.NONCOLOR;
    }

    @Override
    public void jump(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public void watch(Entity entity) throws UnsupportedMethod {

    }

    @Override
    public void watch(Character character) throws UnsupportedMethod {

    }


    @Override
    public void walk(Place newLocation) throws UnsupportedMethod {
        throw new UnsupportedMethod();
    }

    @Override
    public String voiceLine() {
        String message = String.valueOf(VoiceLines.values()[new Random().nextInt(VoiceLines.values().length)]);
        return "— " + "\u001B[31m" + message + "\u001B[0m" + "\033[3m" + String.format(" — Сказал %s в %s", this.getName(), this.getLocation()) + " \033[0m";
    }


}
