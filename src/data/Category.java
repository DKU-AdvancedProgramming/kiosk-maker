package data;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public String name;
    List<Item> items = new ArrayList<>();
    public Category(String name) {
        this.name = name;
    }
    public void add(Item item) {
        items.add(item);
    }
    public Item getItem(int index) { return items.get(index); }

    public int getItemCount() {
		return items.size();
    }
}