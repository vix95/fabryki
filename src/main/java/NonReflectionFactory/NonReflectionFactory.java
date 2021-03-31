package NonReflectionFactory;

import Items.Item;
import Items.PaletteType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonReflectionFactory implements NonReflectionInterface {
    private static NonReflectionFactory instance;
    private final Map<PaletteType, List<Item>> palettes = new HashMap<>();

    private NonReflectionFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static NonReflectionFactory getInstance() {
        if (instance == null) {
            synchronized (NonReflectionFactory.class) {
                if (instance == null) {
                    instance = new NonReflectionFactory();
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
    public List<Item> createPalette(PaletteType type) {
        return palettes.get(type);
    }
}
