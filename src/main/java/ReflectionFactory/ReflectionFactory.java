package ReflectionFactory;

import Items.Item;
import Items.PaletteType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionFactory implements ReflectionInterface {
    private static ReflectionFactory instance;
    private final Map<PaletteType, List<Item>> palettes = new HashMap<>();

    private ReflectionFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static ReflectionFactory getInstance() {
        if (instance == null) {
            synchronized (ReflectionFactory.class) {
                if (instance == null) {
                    instance = new ReflectionFactory();
                }
            }
        }

        return instance;
    }

    @Override
    public void addPalette(PaletteType type, List<Item> list) {
        palettes.put(type, list);
    }

    @Override
    public List<Item> createPalette(PaletteType type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Item> itemList = palettes.get(type);
        List<Item> itemListConstructor = new ArrayList<>();

        for (Item item : itemList) {
            Constructor<? extends Item> constructor = item.getClass().getConstructor();
            itemListConstructor.add(constructor.newInstance());
        }

        return itemListConstructor;
    }
}
