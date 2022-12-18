package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/*
            <-- 사용법 -->
    Data 객체 갖고오기:
        Data data = Data.getData();
    카테고리명 접근:
        data.getCategory(i).name
    아이템 접근:
        data.getCategory(i).getItem(i).name
        data.getCategory(i).getItem(i).price
    식당 이름 접근:
        String data.getName();
*/
public class Data {
    private static Data data;
    private List<Category> categories = new ArrayList<>();

    private String name;

    private Data(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int categoryindex = -1;

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");

                if(line[0].equals("name")) { this.name = line[1]; }
                else if(line[0].equals("category")) {
                    Category category = new Category(line[1]);
                    categories.add(category);
                    categoryindex++;
                }
                else {
                    Item item = new Item(line[0], Integer.parseInt(line[1]));
                    categories.get(categoryindex).add(item);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Data getData() {
        return data;
    }

    public static void setData(File file) {
        data = new Data(file);
    }

    public int getCategoryCount() {
        return categories.size();
    }

    public Category getCategory(int index) {
        return categories.get(index);
    }

    public String getName() { return this.name; }
}
