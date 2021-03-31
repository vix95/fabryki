package FactoryMethod.methods;

import Items.Item;
import Items.Palette_2.*;
import FactoryMethod.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Palette2_FactoryMethod implements FactoryMethod {
    private static Palette2_FactoryMethod instance;

    private Palette2_FactoryMethod() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette2_FactoryMethod getInstance() {
        if (instance == null) {
            synchronized (Palette2_FactoryMethod.class) {
                if (instance == null) {
                    instance = new Palette2_FactoryMethod();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> createPalette() {
        List<Item> list = new ArrayList<>();
        list.add(new Dell());
        list.add(new Disco());
        list.add(new Jewel());
        list.add(new JordyBlue());
        list.add(new Martinique());
        list.add(new Stromboli());

        return list;
    }
}
