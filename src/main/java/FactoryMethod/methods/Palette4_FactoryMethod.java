package FactoryMethod.methods;

import Items.Item;
import Items.Palette_4.*;
import FactoryMethod.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Palette4_FactoryMethod implements FactoryMethod {
    private static Palette4_FactoryMethod instance;

    private Palette4_FactoryMethod() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette4_FactoryMethod getInstance() {
        if (instance == null) {
            synchronized (Palette4_FactoryMethod.class) {
                if (instance == null) {
                    instance = new Palette4_FactoryMethod();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> createPalette() {
        List<Item> list = new ArrayList<>();
        list.add(new HummingBird());
        list.add(new Juniper());
        list.add(new Sirocco());
        list.add(new Swamp());
        list.add(new Tiara());
        list.add(new Turquoise());

        return list;
    }
}
