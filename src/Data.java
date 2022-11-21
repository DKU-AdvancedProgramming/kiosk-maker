import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
            <-- 사용법 -->
    카테고리명 접근:
        data.getCategory(i).name
    아이템 접근:
        data.getCategory(i).getItem(i).name
        data.getCategory(i).getItem(i).price
*/
public class Data {
    List<Category> categories = new ArrayList<>();

    public Data(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) { // 한 라인 씩 읽어서 카테고리를 추가한다.
                String line = scanner.nextLine();
                String[] splitedStrings = line.split(" ,");
                Category category = new Category(splitedStrings[0]);
                for (int i = 1; i < splitedStrings.length; i++) { // 카테고리에 아이템들 추가한다.
                    String name = splitedStrings[i].split(":")[0];
                    int price = Integer.parseInt(splitedStrings[i].split(":")[1]);
                    Item item = new Item(name, price);
                    category.add(item);
                }
                categories.add(category);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public int getCategoryCount() { return categories.size(); }

    public Category getCategory(int index) { return categories.get(index); }
}

class Category {
    String name;
    List<Item> items = new ArrayList<>();
    public Category(String name) {
        this.name = name;
    }
    public void add(Item item) {
        items.add(item);
    }
    public Item getItem(int index) { return items.get(index); }
}

class Item {
    public String name;
    public int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
