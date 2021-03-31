package AbstractFactory;

import Items.Item;
import Items.Palette_2.*;

import java.util.ArrayList;
import java.util.List;

public class Palette2_AbstractFactory implements AbstractFactoryInterface<Palette2_AbstractFactoryInterface> {
    private static Palette2_AbstractFactory instance;

    private Palette2_AbstractFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette2_AbstractFactory getInstance() {
        if (instance == null) {
            synchronized (Palette2_AbstractFactory.class) {
                if (instance == null) {
                    instance = new Palette2_AbstractFactory();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> create() {
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
