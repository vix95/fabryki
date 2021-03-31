package AbstractFactory;

import Items.Item;

import java.util.List;

public interface AbstractFactoryInterface<T> {
    List<Item> create();
}
