import AbstractFactory.AbstractFactoryCreator;
import AbstractFactory.AbstractFactoryInterface;
import AbstractFactory.*;
import FactoryMethod.FactoryMethod;
import FactoryMethod.methods.Palette1_FactoryMethod;
import FactoryMethod.methods.Palette2_FactoryMethod;
import Items.Item;
import Items.PaletteType;
import Items.Palette_1.*;
import Items.Palette_2.*;
import NonReflectionFactory.NonReflectionFactory;
import ReflectionFactory.ReflectionFactory;
import SimpleFactory.SimpleFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTests {
    @Test
    void isNotExistsFactoryTest() {
        SimpleFactory simpleFactory = SimpleFactory.getInstance();
        assertThrows(IllegalStateException.class, () -> simpleFactory.createPalette(PaletteType.PALETTE_NOT_EXIST));
    }

    @Test
    void simpleFactoryTest() {
        SimpleFactory factory = SimpleFactory.getInstance();
        List<Item> list = factory.createPalette(PaletteType.PALETTE_1);

        assertTrue(list.get(0) instanceof Chinook);
        assertTrue(list.get(1) instanceof Cinnamon);
        assertTrue(list.get(2) instanceof ColdPurple);
        assertTrue(list.get(3) instanceof Deco);
        assertTrue(list.get(4) instanceof HoneyFlower);
        assertTrue(list.get(5) instanceof LightWisteria);

        assertEquals(list.get(0).getName(), "Chinook");
        assertEquals(list.get(1).getName(), "Cinnamon");
        assertEquals(list.get(2).getName(), "ColdPurple");
        assertEquals(list.get(3).getName(), "Deco");
        assertEquals(list.get(4).getName(), "HoneyFlower");
        assertEquals(list.get(5).getName(), "LightWisteria");
    }

    @Test
    void factoryMethodTest() {
        FactoryMethod factory_1 = Palette1_FactoryMethod.getInstance();
        FactoryMethod factory_2 = Palette2_FactoryMethod.getInstance();

        List<Item> list_1 = factory_1.createPalette();
        List<Item> list_2 = factory_2.createPalette();

        assertTrue(list_1.get(0) instanceof Chinook);
        assertTrue(list_1.get(1) instanceof Cinnamon);
        assertTrue(list_1.get(2) instanceof ColdPurple);
        assertTrue(list_1.get(3) instanceof Deco);
        assertTrue(list_1.get(4) instanceof HoneyFlower);
        assertTrue(list_1.get(5) instanceof LightWisteria);

        assertEquals(list_1.get(0).getName(), "Chinook");
        assertEquals(list_1.get(1).getName(), "Cinnamon");
        assertEquals(list_1.get(2).getName(), "ColdPurple");
        assertEquals(list_1.get(3).getName(), "Deco");
        assertEquals(list_1.get(4).getName(), "HoneyFlower");
        assertEquals(list_1.get(5).getName(), "LightWisteria");

        assertTrue(list_2.get(0) instanceof Dell);
        assertTrue(list_2.get(1) instanceof Disco);
        assertTrue(list_2.get(2) instanceof Jewel);
        assertTrue(list_2.get(3) instanceof JordyBlue);
        assertTrue(list_2.get(4) instanceof Martinique);
        assertTrue(list_2.get(5) instanceof Stromboli);

        assertEquals(list_2.get(0).getName(), "Dell");
        assertEquals(list_2.get(1).getName(), "Disco");
        assertEquals(list_2.get(2).getName(), "Jewel");
        assertEquals(list_2.get(3).getName(), "JordyBlue");
        assertEquals(list_2.get(4).getName(), "Martinique");
        assertEquals(list_2.get(5).getName(), "Stromboli");
    }

    @Test
    void abstractFactoryTest() {
        AbstractFactoryInterface palette1_factory = AbstractFactoryCreator.create(PaletteType.PALETTE_1);
        AbstractFactoryInterface palette2_factory = AbstractFactoryCreator.create(PaletteType.PALETTE_2);
        AbstractFactoryInterface palette3_factory = AbstractFactoryCreator.create(PaletteType.PALETTE_3);
        AbstractFactoryInterface palette4_factory = AbstractFactoryCreator.create(PaletteType.PALETTE_4);

        assertTrue(palette1_factory instanceof Palette1_AbstractFactory);
        assertTrue(palette2_factory instanceof Palette2_AbstractFactory);
        assertTrue(palette3_factory instanceof Palette3_AbstractFactory);
        assertTrue(palette4_factory instanceof Palette4_AbstractFactory);

        List<Item> list = palette1_factory.create();
        assertTrue(list.get(0) instanceof Chinook);
        assertTrue(list.get(1) instanceof Cinnamon);
        assertTrue(list.get(2) instanceof ColdPurple);
        assertTrue(list.get(3) instanceof Deco);
        assertTrue(list.get(4) instanceof HoneyFlower);
        assertTrue(list.get(5) instanceof LightWisteria);

        assertEquals(list.get(0).getName(), "Chinook");
        assertEquals(list.get(1).getName(), "Cinnamon");
        assertEquals(list.get(2).getName(), "ColdPurple");
        assertEquals(list.get(3).getName(), "Deco");
        assertEquals(list.get(4).getName(), "HoneyFlower");
        assertEquals(list.get(5).getName(), "LightWisteria");
    }

    @Test
    void reflectionFactoryTest() {
        ReflectionFactory factory = ReflectionFactory.getInstance();

        List<Item> list = new ArrayList<>();
        list.add(new Chinook());
        list.add(new Cinnamon());
        list.add(new ColdPurple());
        list.add(new Deco());
        list.add(new HoneyFlower());
        list.add(new LightWisteria());

        factory.addPalette(PaletteType.PALETTE_1, list);

        try {
            List<Item> listAfterReflection = factory.createPalette(PaletteType.PALETTE_1);

            assertTrue(listAfterReflection.get(0) instanceof Chinook);
            assertTrue(listAfterReflection.get(1) instanceof Cinnamon);
            assertTrue(listAfterReflection.get(2) instanceof ColdPurple);
            assertTrue(listAfterReflection.get(3) instanceof Deco);
            assertTrue(listAfterReflection.get(4) instanceof HoneyFlower);
            assertTrue(listAfterReflection.get(5) instanceof LightWisteria);

            assertEquals(listAfterReflection.get(0).getName(), "Chinook");
            assertEquals(listAfterReflection.get(1).getName(), "Cinnamon");
            assertEquals(listAfterReflection.get(2).getName(), "ColdPurple");
            assertEquals(listAfterReflection.get(3).getName(), "Deco");
            assertEquals(listAfterReflection.get(4).getName(), "HoneyFlower");
            assertEquals(listAfterReflection.get(5).getName(), "LightWisteria");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void nonReflectionFactoryTest() {
        NonReflectionFactory factory = NonReflectionFactory.getInstance();

        List<Item> list = new ArrayList<>();
        list.add(new Chinook());
        list.add(new Cinnamon());
        list.add(new ColdPurple());
        list.add(new Deco());
        list.add(new HoneyFlower());
        list.add(new LightWisteria());

        factory.addPalette(PaletteType.PALETTE_1, list);

        try {
            List<Item> listAfterReflection = factory.createPalette(PaletteType.PALETTE_1);

            assertTrue(listAfterReflection.get(0) instanceof Chinook);
            assertTrue(listAfterReflection.get(1) instanceof Cinnamon);
            assertTrue(listAfterReflection.get(2) instanceof ColdPurple);
            assertTrue(listAfterReflection.get(3) instanceof Deco);
            assertTrue(listAfterReflection.get(4) instanceof HoneyFlower);
            assertTrue(listAfterReflection.get(5) instanceof LightWisteria);

            assertEquals(listAfterReflection.get(0).getName(), "Chinook");
            assertEquals(listAfterReflection.get(1).getName(), "Cinnamon");
            assertEquals(listAfterReflection.get(2).getName(), "ColdPurple");
            assertEquals(listAfterReflection.get(3).getName(), "Deco");
            assertEquals(listAfterReflection.get(4).getName(), "HoneyFlower");
            assertEquals(listAfterReflection.get(5).getName(), "LightWisteria");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
