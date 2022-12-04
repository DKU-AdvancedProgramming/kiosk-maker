package data;

public class Item {
    public String name;
    public int price;
    public String imgPath;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.imgPath = "C:\\Users\\손진호\\Desktop\\메뉴이미지\\" + name +".jpg";
    }
}
//"C:\Users\손진호\Desktop\메뉴이미지\일반김밥.jpg"