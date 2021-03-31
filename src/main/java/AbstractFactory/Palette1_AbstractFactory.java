package AbstractFactory;

import Items.Item;
import Items.Palette_1.*;

import java.util.ArrayList;
import java.util.List;

public class Palette1_AbstractFactory implements AbstractFactoryInterface<Palette1_AbstractFactoryInterface> {
    private static Palette1_AbstractFactory instance;

    private Palette1_AbstractFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette1_AbstractFactory getInstance() {
        if (instance == null) {
            synchronized (Palette1_AbstractFactory.class) {
                if (instance == null) {
                    instance = new Palette1_AbstractFactory();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> create() {
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
