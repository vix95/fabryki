package ReflectionFactory;

import Items.Item;
import Items.PaletteType;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ReflectionInterface {
    void addPalette(PaletteType type, List<Item> list);
    List<Item> createPalette(PaletteType type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
