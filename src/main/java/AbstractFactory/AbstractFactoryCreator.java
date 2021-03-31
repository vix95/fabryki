package AbstractFactory;

import Items.PaletteType;

public class AbstractFactoryCreator {

    public static AbstractFactoryInterface create(PaletteType type) {
        return switch (type) {
            case PALETTE_1 -> Palette1_AbstractFactory.getInstance();
            case PALETTE_2 -> Palette2_AbstractFactory.getInstance();
            case PALETTE_3 -> Palette3_AbstractFactory.getInstance();
            case PALETTE_4 -> Palette4_AbstractFactory.getInstance();
            default -> throw new IllegalStateException("Type doesn't exist!");
        };
    }
}
