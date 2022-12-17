import data.Data;
import panels.Panels;
import java.io.File;

//프로젝트 설계도 제안안

public class KioskMaker {
    public static void main(String[] args) {
        File file = new File("Gimbap.txt");
        Data.setData(file);
        Panels.init();
    }
}