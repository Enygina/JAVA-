package sem6;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Notebook Aa = new Notebook("Aa", "a-1", "White", 14.1, 8,128, "SSD");
        Notebook Bb = new Notebook("Bb", "b-2", "Black", 15.1,  16, 256, "SSD");
        Notebook Cc = new Notebook("Cc", "c-3", "Green", 16.1,  32, 512, "SSD");
        Notebook Dd = new Notebook("Dd", "d-4", "Red", 17.1,  64, 1024, "HDD");
        Notebook Ee = new Notebook("Ee", "e-5", "Yellow", 18.1,  64, 2048, "HDD");

        List<Notebook> notebookList = List.of(Aa,Bb,Cc,Dd,Ee);

        Scanner scannerUser = new Scanner(System.in);
        System.out.println("Выберите параметр для поиска:\n1 - по цвету\n2 - по бренду");

        int choiceUserSearch = scannerUser.nextInt();
        Scanner scannerRequestUserForSearch = new Scanner(System.in);
        System.out.println("Введите цвет или бренд: ");
        String requestUserForSearch = scannerRequestUserForSearch.nextLine();

        if (choiceUserSearch == 1) {
            for (Notebook color : notebookList) {
                if (color.getColor().equalsIgnoreCase(requestUserForSearch)) {
                    System.out.println(color.printInfo());
                }
            }

        } else if (choiceUserSearch == 2) {
            for (Notebook brand : notebookList) {
                if (brand.getBrand().equalsIgnoreCase(requestUserForSearch)) {
                    System.out.println(brand.printInfo());
                }
            }
        } else {
            System.out.println("Ошибка.\nВыберите параметр для поиска:\n1 - по цвету\n2 - по бренду");
        }

        scannerUser.close();
    }
}
