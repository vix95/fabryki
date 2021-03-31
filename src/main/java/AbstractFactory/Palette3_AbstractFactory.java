package AbstractFactory;

import Items.Item;
import Items.Palette_3.*;

import java.util.ArrayList;
import java.util.List;

public class Palette3_AbstractFactory implements AbstractFactoryInterface<Palette3_AbstractFactoryInterface> {
    private static Palette3_AbstractFactory instance;

    private Palette3_AbstractFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static Palette3_AbstractFactory getInstance() {
        if (instance == null) {
            synchronized (Palette3_AbstractFactory.class) {
                if (instance == null) {
                    instance = new Palette3_AbstractFactory();
                }
            }
        }

        return instance;
    }

    @Override
    public List<Item> create() {
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
