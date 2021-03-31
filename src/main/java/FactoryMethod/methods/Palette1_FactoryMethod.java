package FactoryMethod.methods;

import Items.Item;
import Items.Palette_1.*;
import FactoryMethod.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Palette1_FactoryMethod implements FactoryMethod {
    private static Palette1_FactoryMethod instance;

    private Palette1_FactoryMethod() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette1_FactoryMethod getInstance() {
        if (instance == null) {
            synchronized (Palette1_FactoryMethod.class) {
                if (instance == null) {
                    instance = new Palette1_FactoryMethod();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> createPalette() {
        List<Item> list = new ArrayList<>();
        list.add(new Chinook());
        list.add(new Cinnamon());
        list.add(new ColdPurple());
        list.add(new Deco());
        list.add(new HoneyFlower());
        list.add(new LightWisteria());

        return list;
    }
}
