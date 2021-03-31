package Benchmark;

import AbstractFactory.AbstractFactoryCreator;
import AbstractFactory.AbstractFactoryInterface;
import FactoryMethod.FactoryMethod;
import FactoryMethod.methods.Palette1_FactoryMethod;
import FactoryMethod.methods.Palette2_FactoryMethod;
import FactoryMethod.methods.Palette3_FactoryMethod;
import FactoryMethod.methods.Palette4_FactoryMethod;
import Items.Item;
import Items.PaletteType;
import Items.Palette_1.*;
import Items.Palette_2.*;
import Items.Palette_3.*;
import Items.Palette_4.*;
import NonReflectionFactory.NonReflectionFactory;
import ReflectionFactory.ReflectionFactory;
import SimpleFactory.SimpleFactory;

import java.util.ArrayList;
import java.util.List;

import static Benchmark.BenchmarkTools.BenchmarkOpsTest;
import static Benchmark.BenchmarkTools.BenchmarkTimeTest;

public class BenchmarkRunner {
    static final long RUN_MILLIS = 4000;
    static final int REPEAT = 15;
    static final int WARMUP = 20;
    static final int LOOP = 10_000;

    static void SimpleFactoryBenchmark() {
        SimpleFactory factory = SimpleFactory.getInstance();
        List<Item> palette_1 = factory.createPalette(PaletteType.PALETTE_1);
        List<Item> palette_2 = factory.createPalette(PaletteType.PALETTE_2);
        List<Item> palette_3 = factory.createPalette(PaletteType.PALETTE_3);
        List<Item> palette_4 = factory.createPalette(PaletteType.PALETTE_4);
    }

    static void FactoryMethodBenchmark() {
        FactoryMethod factory_1 = Palette1_FactoryMethod.getInstance();
        FactoryMethod factory_2 = Palette2_FactoryMethod.getInstance();
        FactoryMethod factory_3 = Palette3_FactoryMethod.getInstance();
        FactoryMethod factory_4 = Palette4_FactoryMethod.getInstance();

        List<Item> palette_1 = factory_1.createPalette();
        List<Item> palette_2 = factory_2.createPalette();
        List<Item> palette_3 = factory_3.createPalette();
        List<Item> palette_4 = factory_4.createPalette();
    }

    static void AbstractFactoryBenchmark() {
        AbstractFactoryInterface factory_1 = AbstractFactoryCreator.create(PaletteType.PALETTE_1);
        AbstractFactoryInterface factory_2 = AbstractFactoryCreator.create(PaletteType.PALETTE_2);
        AbstractFactoryInterface factory_3 = AbstractFactoryCreator.create(PaletteType.PALETTE_3);
        AbstractFactoryInterface factory_4 = AbstractFactoryCreator.create(PaletteType.PALETTE_4);

        List<Item> palette_1 = factory_1.create();
        List<Item> palette_2 = factory_2.create();
        List<Item> palette_3 = factory_3.create();
        List<Item> palette_4 = factory_4.create();
    }

    static void ReflectionFactoryBenchmark() {
        ReflectionFactory factory = ReflectionFactory.getInstance();
        List<Item> palette_1 = new ArrayList<Item>();
        palette_1.add(new Chinook());
        palette_1.add(new Cinnamon());
        palette_1.add(new ColdPurple());
        palette_1.add(new Deco());
        palette_1.add(new HoneyFlower());
        palette_1.add(new LightWisteria());

        List<Item> palette_2 = new ArrayList<Item>();
        palette_2.add(new Dell());
        palette_2.add(new Disco());
        palette_2.add(new Jewel());
        palette_2.add(new JordyBlue());
        palette_2.add(new Martinique());
        palette_2.add(new Stromboli());

        List<Item> palette_3 = new ArrayList<Item>();
        palette_3.add(new Comet());
        palette_3.add(new CornflowerBlue());
        palette_3.add(new LondonHue());
        palette_3.add(new MediumPurple());
        palette_3.add(new Selago());
        palette_3.add(new Woodsmoke());

        List<Item> palette_4 = new ArrayList<Item>();
        palette_4.add(new HummingBird());
        palette_4.add(new Juniper());
        palette_4.add(new Sirocco());
        palette_4.add(new Swamp());
        palette_4.add(new Tiara());
        palette_4.add(new Turquoise());

        factory.addPalette(PaletteType.PALETTE_1, palette_1);
        factory.addPalette(PaletteType.PALETTE_2, palette_2);
        factory.addPalette(PaletteType.PALETTE_3, palette_3);
        factory.addPalette(PaletteType.PALETTE_4, palette_4);
    }

    static void NonReflectionFactoryBenchmark() {
        NonReflectionFactory factory = NonReflectionFactory.getInstance();
        List<Item> palette_1 = new ArrayList<Item>();
        palette_1.add(new Chinook());
        palette_1.add(new Cinnamon());
        palette_1.add(new ColdPurple());
        palette_1.add(new Deco());
        palette_1.add(new HoneyFlower());
        palette_1.add(new LightWisteria());

        List<Item> palette_2 = new ArrayList<Item>();
        palette_2.add(new Dell());
        palette_2.add(new Disco());
        palette_2.add(new Jewel());
        palette_2.add(new JordyBlue());
        palette_2.add(new Martinique());
        palette_2.add(new Stromboli());

        List<Item> palette_3 = new ArrayList<Item>();
        palette_3.add(new Comet());
        palette_3.add(new CornflowerBlue());
        palette_3.add(new LondonHue());
        palette_3.add(new MediumPurple());
        palette_3.add(new Selago());
        palette_3.add(new Woodsmoke());

        List<Item> palette_4 = new ArrayList<Item>();
        palette_4.add(new HummingBird());
        palette_4.add(new Juniper());
        palette_4.add(new Sirocco());
        palette_4.add(new Swamp());
        palette_4.add(new Tiara());
        palette_4.add(new Turquoise());

        factory.addPalette(PaletteType.PALETTE_1, palette_1);
        factory.addPalette(PaletteType.PALETTE_2, palette_2);
        factory.addPalette(PaletteType.PALETTE_3, palette_3);
        factory.addPalette(PaletteType.PALETTE_4, palette_4);
    }

    public static void main(String[] args) {
        // IT'S IMPORTANT TO RUN SEPARATELY
        BenchmarkOpsTest("SimpleFactory", RUN_MILLIS, LOOP, WARMUP, REPEAT, BenchmarkRunner::SimpleFactoryBenchmark);
        BenchmarkOpsTest("FactoryMethod", RUN_MILLIS, LOOP, WARMUP, REPEAT, BenchmarkRunner::FactoryMethodBenchmark);
        BenchmarkOpsTest("AbstractFactory", RUN_MILLIS, LOOP, WARMUP, REPEAT, BenchmarkRunner::AbstractFactoryBenchmark);
        BenchmarkOpsTest("ReflectionFactory", RUN_MILLIS, LOOP, WARMUP, REPEAT, BenchmarkRunner::ReflectionFactoryBenchmark);
        BenchmarkOpsTest("NonReflectionFactory", RUN_MILLIS, LOOP, WARMUP, REPEAT, BenchmarkRunner::NonReflectionFactoryBenchmark);

        BenchmarkTimeTest("SimpleFactory", LOOP, REPEAT, BenchmarkRunner::SimpleFactoryBenchmark);
        BenchmarkTimeTest("FactoryMethod", LOOP, REPEAT, BenchmarkRunner::FactoryMethodBenchmark);
        BenchmarkTimeTest("AbstractFactory", LOOP, REPEAT, BenchmarkRunner::AbstractFactoryBenchmark);
        BenchmarkTimeTest("ReflectionFactory", LOOP, REPEAT, BenchmarkRunner::ReflectionFactoryBenchmark);
        BenchmarkTimeTest("NonReflectionFactory", LOOP, REPEAT, BenchmarkRunner::NonReflectionFactoryBenchmark);
    }
}

