package AbstractFactory;

import Items.Item;
import Items.Palette_4.*;

import java.util.ArrayList;
import java.util.List;

public class Palette4_AbstractFactory implements AbstractFactoryInterface<Palette4_AbstractFactoryInterface> {
    private static Palette4_AbstractFactory instance;

    private Palette4_AbstractFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette4_AbstractFactory getInstance() {
        if (instance == null) {
            synchronized (Palette4_AbstractFactory.class) {
                if (instance == null) {
                    instance = new Palette4_AbstractFactory();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> create() {
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
