package SimpleFactory;

import Items.Item;
import Items.PaletteType;
import Items.Palette_1.*;
import Items.Palette_2.*;
import Items.Palette_3.*;
import Items.Palette_4.*;

import java.util.ArrayList;
import java.util.List;

public class SimpleFactory {
    private static SimpleFactory instance;

    private SimpleFactory() {
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton is exist");
        }
    }

    public static SimpleFactory getInstance() {
        if (instance == null) {
            synchronized (SimpleFactory.class) {
                if (instance == null) {
                    instance = new SimpleFactory();
                }
            }
        }

        return instance;
    }

    public List<Item> createPalette(PaletteType type) {
        switch (type) {
            case PALETTE_1 -> {
                return this.createPalette_1();
            }
            case PALETTE_2 -> {
                return this.createPalette_2();
            }
            case PALETTE_3 -> {
                return this.createPalette_3();
            }
            case PALETTE_4 -> {
                return this.createPalette_4();
            }
            default -> throw new IllegalStateException("Type doesn't exist!");
        }
    }

    private List<Item> createPalette_1() {
        List<Item> list = new ArrayList<>();
        list.add(new Chinook());
        list.add(new Cinnamon());
        list.add(new ColdPurple());
        list.add(new Deco());
        list.add(new HoneyFlower());
        list.add(new LightWisteria());

        return list;
    }

    private List<Item> createPalette_2() {
        List<Item> list = new ArrayList<>();
        list.add(new Dell());
        list.add(new Disco());
        list.add(new Jewel());
        list.add(new JordyBlue());
        list.add(new Martinique());
        list.add(new Stromboli());

        return list;
    }

    private List<Item> createPalette_3() {
        List<Item> list = new ArrayList<>();
        list.add(new Comet());
        list.add(new CornflowerBlue());
        list.add(new LondonHue());
        list.add(new MediumPurple());
        list.add(new Selago());
        list.add(new Woodsmoke());

        return list;
    }

    private List<Item> createPalette_4() {
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