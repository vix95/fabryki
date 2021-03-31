package NonReflectionFactory;

import Items.Item;
import Items.PaletteType;

import java.util.List;

public interface NonReflectionInterface {
    void addPalette(PaletteType type, List<Item> list);
    List<Item> createPalette(PaletteType type);
}
