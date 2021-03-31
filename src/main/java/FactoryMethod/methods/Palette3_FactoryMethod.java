package FactoryMethod.methods;

import Items.Item;
import Items.Palette_3.*;
import FactoryMethod.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

public class Palette3_FactoryMethod implements FactoryMethod {
    private static Palette3_FactoryMethod instance;

    private Palette3_FactoryMethod() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette3_FactoryMethod getInstance() {
        if (instance == null) {
            synchronized (Palette3_FactoryMethod.class) {
                if (instance == null) {
                    instance = new Palette3_FactoryMethod();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> createPalette() {
        List<Item> list = new ArrayList<>();
        list.add(new Comet());
        list.add(new CornflowerBlue());
        list.add(new LondonHue());
        list.add(new MediumPurple());
        list.add(new Selago());
        list.add(new Woodsmoke());

        return list;
    }
}
